import sys

n, m = map(int, sys.stdin.readline().split())
parents = [-1] * (n + 1)

def find(a):
    global parents
    if parents[a] < 0:
        return a
    parents[a] = find(parents[a])
    return parents[a]

def check(a, b):
    if find(a) == find(b):
        return True
    return False


def union(a, b):
    global parents
    p_a = find(a)
    p_b = find(b)
    if p_a != p_b:
        parents[p_b] =p_a


for i in range(m):
    op, a, b = map(int, sys.stdin.readline().split())
    if op == 0:
        union(a, b)
    elif op == 1:
        print("YES" if check(a, b) else "NO")