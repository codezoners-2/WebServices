from flask import Flask, render_template, request
import os, re
import logic


app = Flask(__name__)

corpus = logic.filesToDict(['data/' + f for f in os.listdir('data')])

def crop(name):
    pat = r'''
    .*          # Any prefix
    [/\\]       # Directory separator
    '''
    return re.sub(pat, '', name, flags=re.VERBOSE)

@app.route('/', methods=['GET', 'POST'])
@app.route('/index', methods=['GET', 'POST'])
def do_search():
    if request.method == 'POST':
        term = request.form.get('term')
        if term:
            items = sorted(logic.freqAnalyserNorm(corpus, term).items())
            return render_template('results_bootstrap.html',
                                   term=term,
                                   items=[(crop(name), amounts) for name, amounts in items])
        else:
            return render_template('results_bootstrap.html',
                                   items=None)
    else:
        return render_template('results_bootstrap.html',
                               items=None)

#app.run(host='0.0.0.0', port=8080, debug=True)
