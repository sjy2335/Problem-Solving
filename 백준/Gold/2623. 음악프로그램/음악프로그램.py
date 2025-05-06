import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

adj: list[list[int]] = [[] for _ in range(N)]
indegrees = {i: 0 for i in range(N)}

for _ in range(M):
    # Get Input as 0-based indices
    info = list(map(lambda x: int(x) - 1, sys.stdin.readline().split()))
    for i in range(1, len(info) - 1):
        a, b = info[i], info[i + 1]
        adj[a].append(b)
        indegrees[b] += 1

q = deque()
for node in indegrees:
    if indegrees[node] == 0:
        q.append(node)

answer = []
impossible = False

for _ in range(N):
    if not q:
        impossible = True
        break
    curr = q.popleft()
    answer.append(curr + 1)
    for neighbor in adj[curr]:
        indegrees[neighbor] -= 1
        if indegrees[neighbor] == 0:
            q.append(neighbor)

if impossible: print("0")
else: print("\n".join(map(str, answer)))