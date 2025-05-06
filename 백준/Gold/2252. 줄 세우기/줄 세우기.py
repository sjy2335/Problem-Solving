import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

"""
N <= 32,000
M <= 100,000

Topological Sort!
"""

adj: list[list[int]] = [list() for _ in range(N)]
visited = [False] * N
indegrees = {i: 0 for i in range(N)}

for _ in range(M):
    a, b = map(lambda x: int(x) - 1, sys.stdin.readline().split())
    adj[a].append(b)
    indegrees[b] += 1

q = deque()
for key in indegrees:
    if indegrees[key] == 0:
        q.append(key)
        visited[key] = True

result = []
for _ in range(N):
    curr = q.popleft()
    result.append(curr + 1)
    for neighbor in adj[curr]:
        indegrees[neighbor] -= 1
        if indegrees[neighbor] == 0: # indegree가 0이 되었다면 큐에 추가
            q.append(neighbor)

print(*result)