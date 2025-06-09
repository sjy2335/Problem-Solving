import sys
from collections import defaultdict

"""
개수를 세고 하나씩 뺀다면 O(N) 20만개 충분히 가능
중복되거나 불필요한 작업이 있나?
투포인터 사용해서 한번의 순회로 끝낼 수 있음!
"""

read_line = sys.stdin.readline
N = int(read_line())
fruits = list(map(int, read_line().split()))

left = 0
right = 0
fruits_count = defaultdict(int)
fruits_count[fruits[0]] = 1

answer = 1

for right in range(1, N):
    fruits_count[fruits[right]] += 1

    while len(fruits_count) > 2:
        fruits_count[fruits[left]] -= 1
        if fruits_count[fruits[left]] == 0:
            del fruits_count[fruits[left]]
        left += 1

    answer = max(answer, right - left + 1)

print(answer)