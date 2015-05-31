import mongoengine as db

passwd = raw_input("pass: ")
c = db.connect(host=("mongodb://test1:%s@ds033390.mongolab.com:33390/test1" % passwd))
