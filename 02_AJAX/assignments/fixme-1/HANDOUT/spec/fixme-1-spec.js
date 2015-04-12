m = require("../fixme-1");

describe("The Python unit tests", function() {
    it("adder: adds numbers", function() {
        expect(m.adder(2, 2)).toBe(4);
        expect(m.adder(3, 4)).toBe(7);
    });

    it("haircut chops ends from a list", function() {
        expect(m.haircut([0, 1, 2, 3, 4])).toEqual([1, 2, 3]);
    });

    it("wordSlicer returns elements up until a word", function() {
        expect(m.wordSlider(["use", "the", "force", "Luke"], "force")).toEqual(["use", "the"]);
    });
});
