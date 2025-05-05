import sys

def get_time_required(target, ground, B):
    time = 0
    for g in ground:
        for height in g:
            if target > height:
                inserted = target - height
                time += inserted
                B -= inserted
            else:
                removed = height - target
                time += 2 * removed
                B += removed
    return time if B >= 0 else -1

N, M, B = map(int, sys.stdin.readline().split())

arr = []
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

res_time = 1e9
res_height = -1
for height in range(0, 257):
    tmp_time = get_time_required(height, arr, B)
    if tmp_time == -1: continue
    if tmp_time <= res_time:
        res_time = tmp_time
        res_height = height

print(f"{res_time} {res_height}")