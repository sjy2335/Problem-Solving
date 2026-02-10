import sys

rl = sys.stdin.readline

class Point:
    def __init__(self, x: int, y: int):
        self.x = x
        self.y = y
        
    def __eq__(self, other):
        return self.x == other.x and self.y == other.y
    
    def __lt__(self, other):
        if self.x == other.x:
            return self.y < other.y
        return self.x < other.x

N = int(rl())
points = []

for _ in range(N):
    x, y = map(int, rl().split())
    points.append(Point(x, y))
    
points.sort()

for point in points:
    print(f"{point.x} {point.y}")