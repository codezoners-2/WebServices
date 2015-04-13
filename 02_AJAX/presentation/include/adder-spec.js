m = require("../fixme-1");

it("adder: adds numbers", function() {
    expect(m.adder(2, 2)).toBe(4);
    expect(m.adder(3, 4)).toBe(7);
});
