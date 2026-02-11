import sys
rl = sys.stdin.readline # helper function

class Point:
    def __init__(self, x: int, y: int):
        self.x = x
        self.y = y
        
    def __eq__(self, other: "Point"):
        if not isinstance(other, Point):
            return NotImplemented
        if self.x != other.x:
            return False
        return self.y == other.y
    
    def __lt__(self, other: "Point"):
        if not isinstance(other, Point):
            return NotImplemented
        if self.y != other.y: # Explicitly check y first
            return self.y < other.y
        return self.x < other.x

N = int(rl().strip())

points: list[Point] = []

for _ in range(N):
    x, y = map(int, rl().split())
    points.append(Point(x, y))

points.sort()

for p in points:
    print(f"{p.x} {p.y}")