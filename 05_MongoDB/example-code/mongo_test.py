'''
Quick test for Mongo DB.
'''

from mongoengine import *

c = connect(host=("mongodb://test1:%s@ds033390.mongolab.com:33390/test1" % raw_input("pass: ")))

class Person(Document):
    first_name = StringField(required=True)
    last_name = StringField(required=True)

CREATE = False

if CREATE:
    me = Person(first_name="Nick", last_name="Rothwell")
    me.save()
    # After this, we have a collection called "person".

for p in Person.objects:
    print p.last_name
