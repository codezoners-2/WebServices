import mongoengine as db

dbname = "test1"
user = "test1"
passwd = raw_input("pass: ")

c = db.connect(host=("mongodb://{user}:{passwd}@ds033390.mongolab.com:33390/{dbname}"
                     .format(user=user, passwd=passwd, dbname=dbname)))
