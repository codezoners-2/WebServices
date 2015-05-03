import random
import math

def makeStack(n):
    return [{'rgb': [0, 0, 0],
             'x': i / n,
             'y': i / n,
             'r': 0.1,
             'key': i} for i in range(n)]
