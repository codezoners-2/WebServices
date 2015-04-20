from flask import Flask
import os
import logic
from flask.ext.cors import CORS

app = Flask(__name__)
cors = CORS(app)

corpus = logic.filesToDict(['data/' + f for f in os.listdir('data')])

@app.route('/')
def index():
    return "Server is running"

@app.route('/search/<term>')
def search(term):
	pass

app.run(host='0.0.0.0', port=8080, debug=True)
