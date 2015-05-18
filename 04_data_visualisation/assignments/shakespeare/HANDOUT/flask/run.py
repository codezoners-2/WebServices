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
    return jsonify({'result': [{'text': 'ONE', 'value': 50},
                               {'text': 'TWO', 'value': 50}]})

@app.route('/random')
def pattern2():
    return jsonify({'result': [{'text': 'R1', 'value': random.randint(1, 10)},
                               {'text': 'R2', 'value': random.randint(1, 10)},
                               {'text': 'R3', 'value': random.randint(1, 10)}]})

@app.route('/twenty')
def pattern3():
    return jsonify({'result': [{'text': i, 'value': 1} for i in range(20)]})

app.run(host='0.0.0.0', port=8080, debug=True)
