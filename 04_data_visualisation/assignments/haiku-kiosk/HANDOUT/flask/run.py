from flask import Flask, render_template, jsonify
import os, random
import logic

app = Flask(__name__)

# Look to the Shakespeare example for how to preload all the content.

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/fetch')
def fetch():
    # You'll need some code in logic.py. Think carefully about what kind of structure
    # you are going to pass back into D3.
    pass

app.run(host='0.0.0.0', port=8080, debug=True)
