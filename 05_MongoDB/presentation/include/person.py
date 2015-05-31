class Person(db.Document):
    first_name = db.StringField(required=True)
    last_name = db.StringField(required=True)
