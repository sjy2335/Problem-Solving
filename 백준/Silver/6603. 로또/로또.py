import sys
from itertools import combinations

while True:
    k, *arr = map(int, sys.stdin.readline().split())
    if k == 0: break
    for comb in combinations(arr, 6):
        print(*comb)
    print()