render: function() {
    return (
        // Note the map, to turn each entry into an <LI> with a link and description.
            <div><ul>{this.state.gists.map(function (x) {
                return <li>{x.description}</li>;
            })}</ul></div>
    );
}
