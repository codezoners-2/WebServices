from flask import Flask, render_template, request
import os, re
import logic

app = Flask(__name__)

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

app.run(host='0.0.0.0', port=8080, debug=True)
