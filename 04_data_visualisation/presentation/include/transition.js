d3.selectAll("p")
    .style("color", "white")
    .transition()
    .delay(function (d, i) { return i * 500; })
    .duration(3000)
    .style("color", "black");
