import sys

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

left = 0
accumulated = 0
answer = 1e9

for right in range(N):
    accumulated += arr[right]

    while accumulated >= S:
        answer = min(answer, right - left + 1)
        accumulated -= arr[left]
        left += 1

print(answer if answer != 1e9 else 0)