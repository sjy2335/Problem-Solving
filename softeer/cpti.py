import sys
from collections import Counter

input = sys.stdin.readline

N, M = map(int, input().split())
cptis = [int(input().strip(), 2) for _ in range(N)]
counter = Counter(cptis)

answer = 0

# Check the ones with same masks
for mask in counter:
    answer += counter[mask] * (counter[mask] - 1) // 2 # Combination of Two

# Check the one or two bit differed ones
for mask in counter:
    for i in range(M):
        diff1 = mask ^ (1 << i) # mask의 나머지 자리 전부 그대로, i번째가 1이었으면 그자리가 0이되고, 0이었으면 1이 됨
        if diff1 in counter and diff1 > mask: # and 이후는 한쪽 방향으로만 확인하기 위한 조건
            answer += counter[mask] * counter[diff1]
        for j in range(i + 1, M):
            diff2 = mask ^ (1 << i) ^ (1 << j)
            if diff2 in counter and diff2 > mask:
                answer += counter[mask] * counter[diff2]

print(answer)