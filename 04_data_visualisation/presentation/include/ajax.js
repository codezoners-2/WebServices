d3.json('/fetch', function (error, json) {
    if (error) { return console.warn(error); }

    d3.selectAll("p").data(json).text(...);
});
