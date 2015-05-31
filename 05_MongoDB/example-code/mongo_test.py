'''
Quick test for Mongo DB.
'''

import mongoengine as db

passwd = raw_input("pass: ")
c = db.connect(host=("mongodb://test1:%s@ds033390.mongolab.com:33390/test1" % passwd))

class Person(db.Document):
    first_name = db.StringField(required=True)
    last_name = db.StringField(required=True)

for p in Person.objects.all():
    p.delete()

for first_name, last_name in [('Max', 'Rockatansky'),
                              ('Imperator', 'Furiosa'),
                              ('Immortan', 'Joe'),
                              ('Imperator', 'Ripsaw')]:
    Person(first_name=first_name, last_name=last_name).save()

for p in Person.objects.all():
    print p.first_name, p.last_name

print "---"

for p in Person.objects(first_name="Imperator"):
    p.delete()

for p in Person.objects.all():
    print p.first_name, p.last_name
