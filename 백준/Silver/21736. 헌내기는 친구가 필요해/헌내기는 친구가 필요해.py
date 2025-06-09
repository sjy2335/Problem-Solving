import sys
from collections import deque

dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]

N, M = map(int, sys.stdin.readline().split())

campus = []
visited = [[False] * M for _ in range(N)]
start = ()

for i in range(N):
    row = sys.stdin.readline()
    found = row.find('I')
    if found != -1:
        start = (i, found)
    campus.append(list(row.strip()))

count = 0
dq = deque()

dq.append(start)
visited[start[0]][start[1]] = True

while dq:
    r, c = dq.pop()
    if campus[r][c] == 'P':
        count += 1
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]
        if nr < 0 or nc < 0 or nr >= N or nc >= M: continue
        if visited[nr][nc]: continue
        if campus[nr][nc] == 'X': continue
        dq.append((nr, nc))
        visited[nr][nc] = True

print(count if count != 0 else 'TT')
