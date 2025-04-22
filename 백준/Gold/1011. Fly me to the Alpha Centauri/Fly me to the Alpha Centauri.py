import sys
import math

def min_moves(x, y):
    distance = y - x
    n = int(math.sqrt(distance))
    if distance == n * n:
        return 2 * n - 1
    elif distance <= n * n + n:
        return 2 * n
    else:
        return 2 * n + 1

T = int(sys.stdin.readline())
for _ in range(T):
    x, y = map(int, sys.stdin.readline().split())
    print(min_moves(x, y))