function oneCycle() {
    // Each time round, fetch another kaiku:
    d3.json('/fetch', function (error, json) {
        if (error) { return console.warn(error); }

        /* Run the entire animation sequence: */
        /* 1. Set the text. */
        /* 2. Fade in. */
        /* 3. Some time later, fade out. */
    });
}

setInterval(oneCycle, 10000);
oneCycle();
