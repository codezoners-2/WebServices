var WIDTH = 600;
var HEIGHT = 600;
var RADIUS = Math.min(WIDTH, HEIGHT) / 2;

var color = d3.scale.category20();

var svg = d3.select("div#inner").append("svg")
        .attr("width", WIDTH)
        .attr("height", HEIGHT)
        .append("g")
        .attr("transform", "translate(" + WIDTH / 2 + ", " + HEIGHT / 2 + ")");

function go(url) {
    d3.json(url, function (error, json) {
        if (error) { return console.warn(error); }

        // Arc generator:
        arc = d3.svg.arc()
            .outerRadius(RADIUS - 10)
            .innerRadius(RADIUS - 70);

        // Pie generator: scales inputs, generates start/end angles...:
        pie = d3.layout.pie()
            .sort(null)
            .value (function (d) { return +d.value; });

        // Attach data:
        data = svg.selectAll(".arc").data(pie(json.result));

        // Enter sequence: add new "g" (group) elements with paths and text:
        g = data.enter()
            .append("g")
            .attr("class", "arc");

        g.append("path")
            .attr("d", arc)
            .style("fill", function (d, i) { return color(i); })
            .each(function(d) {
                console.log("enter on " + JSON.stringify(d));
                this._current = d.data;
            });

        g.append("text")
            .attr("transform", function (d) {
                return "translate(" + arc.centroid(d) + ")";
            })
            .attr("dy", ".35em")
            .style("text-anchor", "middle")
            .text(function (d) { return "X" + d.data.text; });

        // For all data: update arcs and text:
        data.select("path")
            .transition()
            .delay(250)
            .duration(2000)
        /*.attr("d", arc)*/  /*linear tween: horrid!*/
            .attrTween("d", arcTween);

        data.select("text")
            .text(function (d) { return d.data.text; })
            .attr("transform", function (d) {
                return "translate(" + arc.centroid(d) + ")";
            });

        // Remove obsolete elements:
        data.exit().remove();
    });
}

function arcTween(a) {
    console.log("_current: " + this._current);
    var i = d3.interpolate(this._current, a);
    this._current = i(0);
    return function(t) {
        return arc(i(t));
    };
}
