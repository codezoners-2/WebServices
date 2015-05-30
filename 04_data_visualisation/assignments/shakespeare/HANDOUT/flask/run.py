from flask import Flask, render_template, jsonify
import os, random

app = Flask(__name__)

searchWords = ["love", "hate",
               "king", "queen",
               "country", "kingdom",
               "army", "navy",
               "revenge", "justice",
               "romeo", "asjasjasjasj"]

@app.route('/')
def index():
    return render_template('index.html', searchWords=searchWords)

@app.route('/one-two')
def pattern1():
    ll = [{'text': 'ONE', 'value': 50},
          {'text': 'TWO', 'value': 50}]
    for i in range(2, 20):
        ll.append({'text': None, 'value': 0})

    return jsonify({'result': ll})

@app.route('/random')
def pattern2():
    return jsonify({'result': [{'text': i, 'value': random.randint(1, 20)} for i in range(20)]})

@app.route('/ten')
def pattern3():
    return jsonify({'result': [{'text': i, 'value': (i % 2)} for i in range(20)]})

app.run(host='0.0.0.0', port=8080, debug=True)
