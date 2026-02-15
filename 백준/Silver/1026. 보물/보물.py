import sys
rl = sys.stdin.readline

N = int(rl())

A = list(map(int, rl().split()))
A.sort()

B = list(map(int, rl().split()))
B_used = [False] * N

answer = 0

for a in A:
    max_available = 0
    max_index = -1
    for i, b in enumerate(B):
        if b > max_available and not B_used[i]:
            max_available = b
            max_index = i
    answer += a * max_available
    B_used[max_index] = True

print(answer)