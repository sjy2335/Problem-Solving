import sys
import heapq

stdrl = sys.stdin.readline

n = int(stdrl())
m = int(stdrl())

adj = [[] for _ in range(n)]
for _ in range(m):
    u, v, e = map(int, stdrl().split())
    adj[u - 1].append((e, v - 1))

A, B = map(int, stdrl().split())
A -= 1
B -= 1

# A -> B
# 최소 비용, 경로 내 도시 개수, 방문 도시 순서대로 출력

dijkstra = [1e9] * n
dijkstra[A] = 0

pq = []
heapq.heappush(pq, (0, A, [A]))

while pq:
    dist, curr, history = heapq.heappop(pq)
    if dist > dijkstra[curr]: # 없으면 인접리스트 다시 탐색해야 함
        continue
    if curr == B:
        print(dist)
        print(len(history))
        print(' '.join(map(lambda x: str(x + 1), history)))
        break
    for edge, next in adj[curr]:
        next_dist = dist + edge
        if next_dist < dijkstra[next]:
            dijkstra[next] = next_dist
            heapq.heappush(pq, (next_dist, next, history + [next]))

