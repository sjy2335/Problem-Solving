import sys
import heapq

rl = sys.stdin.readline

N = int(rl().strip())

heap = []

for _ in range(N):
    size = int(rl().strip())
    heapq.heappush(heap, size)

answer = 0
while len(heap) > 1:
    tmp = heapq.heappop(heap) + heapq.heappop(heap)
    answer += tmp
    heapq.heappush(heap, tmp)

print(answer)