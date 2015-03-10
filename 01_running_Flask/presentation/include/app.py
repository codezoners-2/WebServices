from flask import Flask, render_template
app = Flask(__name__)

@app.route('/index/<name>')
def index(name="default"):
    return render_template('index.html', title=name)

app.run(host='0.0.0.0', port=8080, debug=True)
