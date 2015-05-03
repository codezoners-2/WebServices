var svg = d3.select("div#inner").append("svg")
        .attr("width", 600)
        .attr("height", 600);

function rgb_str(d) {
    return "rgb(" + (d.rgb[0]*255).toFixed() + ", " + (d.rgb[1]*255).toFixed() + ", " + (d.rgb[2]*255).toFixed() + ")";
}

var counter = 0;

function oneCycle(path) {
    d3.json(path + "/" + counter, function (error, json) {
        if (error) { return console.warn(error); }

        var circle = svg.selectAll("circle");
        c = circle.data(json.result, function(d) { return +d.key; });

        c.attr("cx", function (d) { return d.x * 600; })
            .attr("cy", function (d) { return d.y * 600; })
            .attr("r", function(d) { return d.r * 40; });

        c.enter().append("circle")
            .attr("cx", function (d) { return d.x * 600; })
            .attr("cy", function (d) { return d.y * 600; })
            .attr("r", function(d) { return d.r * 40; });

        c.exit()
            .remove();

    });

    counter = counter + 1;
}

function go(path) {
    setInterval(function() { oneCycle(path); }, 3000);
    oneCycle(path);
}
