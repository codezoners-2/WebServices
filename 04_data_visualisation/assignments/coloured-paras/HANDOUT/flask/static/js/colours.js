d3.json('/colours', function (error, json) {
    if (error) { return console.warn(error); }

    d3.selectAll("p")
        .data(json.result)
        .style("font-size", function (d, i) { return (i + 10) + "px"; })
        .style("color", function (d) { return "rgb(" + d[0] + "," + d[1] + "," + d[2] + ")"; });
});
