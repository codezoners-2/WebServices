/** @jsx React.DOM */

var UserGists = React.createClass({
    getInitialState: function() {
        // Start with empty list of gists:
        return {gists: []};
    },

    componentDidMount: function() {
        $.ajax({type: "GET",
                url: "https://api.github.com/users/octocat/gists",
                success: function(result) {
                    // Check component is still in page:
                    if (this.isMounted()) {
                        this.setState({gists: result});
                    }
                    // bind() to make sure 'this' is set correctly on callback.
                }.bind(this)});
    },

    render: function() {
        return (
            // Note the map, to turn each entry into an <LI> with a link and description.
                <div><ul>{this.state.gists.map(function (x) {
                    return <li>{x.description}</li>;
                })}</ul></div>
        );
        }
    });

React.renderComponent(
    <UserGists />,
    document.getElementById("content")
);
