d3.selectAll("p")
    .data([4, 8, 15, 16, 23, 42])
    .style("font-size", function(d) { return d + "px"; });

d3.selectAll("p")
    .data(["These", "are", "some", "lines", "of", "code"])
    .text(function(d, i) { return "Line " + i + ": " + d; });
