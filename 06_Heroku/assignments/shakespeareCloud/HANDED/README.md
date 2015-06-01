`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# Shakespeare on the cloud
In this exercise we are going to take a classic and put it on the cloud using Heroku's platform.

### Prerequisites:
  * python, virtualenv, pip
  * a heroku account. Sign-up [here](https://signup.heroku.com/signup/dc)
  * make a **copy** of the shakespeareCloud folder to another directory

### Local machine setup:
  * Download Heroku toolbelt for [GNU/Linux](https://devcenter.heroku.com/toolbelt-downloads/debian), [MacOSX](https://devcenter.heroku.com/toolbelt-downloads/osx) or [Windows](https://devcenter.heroku.com/toolbelt-downloads/windows). On GNU/Linux you can also run `sudo apt-get install heroku-toolbelt`. If it asks for public key just click `Y`.
  * Once installed run on the command line `heroku login` and when prompted enter the email/password you gave to heroku when you signed up.
  
### Start Flask inside a virtualenv
  * cd into your app's directory
  * run `virtualenv venv`
  * run `source venv/bin/activate`
  * run `pip install Flask gunicorn` which installs the gunicon webserver, a server designed to run python apps. Until now we were running our apps on the development server of Flask, which is not ideal for production environments.
  * remove APP line from code

### Declare process types with Procfile
  * create a `Procfile` in the root directory and write in it this: `web: gunicorn shakecloud:app --log-file=-` which tells heroku what kind of processes it needs to run (remember web vs. worker)
  * **important**: replace the `shakecloud` word with something that is unique to you. Perhaps a username or alias you often use. That will be the name of your app. Make sure you rename the `shakecloud.py` file to that too.

### Specify dependencies with Pip
  * Run `pip freeze > requirements.txt` which saves all the modules used by your app. This includes Flask, Jinja, Gunicorn etc. Open up the `requirements.txt` file to see what your application requires.

### Store your app in a Git repository
  * create a `.gitignore` file
  * fill it with the following two lines:
  
  ```
  venv
  *.pyc
  ```
  which tell the git not to upload your virtual environment to heroku as we don't need it as well as any compiled python code.
  * run `git init` to initialize an empty repository
  * run `git add .` to add all files (apart from the ones inside the `.gitignore`)
  * run `git commit -m "init"` to commit the additions/changes you made. This should print a list of all the files added to the repository.

### Deploy app in Heroku
  * run `heroku create NAME_OF_YOUR_APP` where NAME_OF_YOUR_APP is the name you gave to your app in the steps above. In my case it was `shakecloud` but you should use something different as it won't allow duplicates.
  * run `git push heroku master` in order to upload your code to Heroku.

### Final steps
  * visit your app by going to `http://NAME_OF_YOUR_APP.herokuapp.com`
  * Free Heroku apps are put to sleep after 30 minutes of inactivity and it takes a few seconds to wake them up when someone accesses them after a while. To avoid this delay just submit your app's name in the [Kaffeine](http://kaffeine.herokuapp.com/) service which pings your app every 30 minutes to make sure it never goes to sleep.
  * Share the app with your friends a feel pride!

### more information:
  * [detailed account](https://devcenter.heroku.com/articles/getting-started-with-python-o) of above
  * [yet another detailed, but friendly](https://devcenter.heroku.com/articles/getting-started-with-python#introduction) step-by-step guide
