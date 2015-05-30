var circle = svg.selectAll("circle");
c = circle.data(json.result, function(d) { return +d.key; });
