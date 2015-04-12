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
}
