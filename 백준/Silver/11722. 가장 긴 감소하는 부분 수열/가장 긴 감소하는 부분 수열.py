import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

memo = [1] * N

for i in range(N):
    for j in range(i + 1, N):
        if arr[i] > arr[j]:
            memo[j] = max(memo[j], memo[i] + 1)

print(max(memo))