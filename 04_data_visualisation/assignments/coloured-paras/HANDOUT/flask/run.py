from flask import Flask, render_template, jsonify
import os, random

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/colours')
def colours():
    colour = [0, 0, 0]
    resp = jsonify({'result': [colour for i in range(10)]})
    resp.status_code = 200
    return resp

app.run(host='0.0.0.0', port=8080, debug=True)
