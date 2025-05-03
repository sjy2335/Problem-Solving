import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())

"""
485를 4로 나누면 121. 110은 이보다 작음. 485에서 110 빼면 375.
375를 3로 나누면 125. 120은 이보다 작음. 375에서 120 빼면 255.
255를 2로 나누면 127. 140은 이보다 큼. 전부다 127로 맞춤. 

시간 복잡도? 
정렬 -> NlogN ... 30000
N 전체 순회 -> N
따라서 NlogN

총 예산 10억이므로 자료형도 그냥 int 괜찮음.
"""

def get_biggest_budget(regions, capacity, budgets):

    list.sort(budgets)

    for budget in budgets:
        upper_limit = capacity // regions
        if budget <= upper_limit:
            capacity -= budget
            regions -= 1
        else:
            return upper_limit

    return budgets[len(budgets) - 1]

print(get_biggest_budget(N, M, arr))
