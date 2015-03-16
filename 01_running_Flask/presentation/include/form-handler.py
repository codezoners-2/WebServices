@app.route('/', methods=['GET', 'POST'])
@app.route('/index', methods=['GET', 'POST'])
def do_search():
    if request.method == 'POST':
        term = request.form.get('term')
        if term:
            # Display search results
        else:
            # Show search form only
    else:
        # Show search form only
