`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# RUNNING FLASK

Here is a simple, stand-alone Flask program which presents a basic `Hello World` page:

        from flask import Flask
        app = Flask(__name__)

        @app.route('/')
        def hello_world():
            return 'Hello World!'

        if __name__ == '__main__':
            app.run()

1. Install `virtualenv` according to the instructions in the slides. If you're not sure what's installed on your laptop, try out the commands in reverse order.

   - Do you have `virtualenv`? If not, you'll need to install it using `pip`.
   
   - Do you have `pip`? If not, you'll need to install *that* using `easy_install`.
   
   - Do you have `easy_install`? If not, you'll need to install *that* using `setuptools`.
   
On Windows, you may well have some of these programs installed, but not in your search path; check `C:\PythonXX` and `C:\PythonXX\Scripts` first. Modify your path if necessary.

1. Create a virtual environment. I tend to use a name like `venv`, but the name should really reflect the purpose of the environment, like `basic_flask_env`.

1. Create a `run.py` with the simple Flask program, as above.

1. Activate your new virtual environment and do a `pip install Flask`.

1. Run the program with `python run.py`. You should see some output like this:

        * Running on http://127.0.0.1:5000/ (Press CTRL+C to quit)
        
1. Check `http://127.0.0.1:5000/` in your browser.

1. *Bonus*: modify the page to display the version information for the version of Python that you're running. Can you build two virtual environments: one for Python 2 and one for Python 3? (`virtualenv -p <python-version>`.) You need to have each version of Python already installed somewhere on your machine. (On the Mac, there's something called `homebrew` for installing console programs: see [brew.sh](http://brew.sh/).)
