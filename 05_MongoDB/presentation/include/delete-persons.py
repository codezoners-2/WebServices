for p in Person.objects(last_name="Furiosa"):
    p.delete()
