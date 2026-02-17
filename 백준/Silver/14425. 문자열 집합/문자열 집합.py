import sys

r = sys.stdin.readline
w = sys.stdout.write

N, M = map(int, r().split())

name_set = set()

for i in range(N):
    name = r().strip()
    name_set.add(name)

answer = 0
for i in range(M):
    name = r().strip()
    if name in name_set:
        answer += 1

w(str(answer))