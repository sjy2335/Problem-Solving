import sys

readline = sys.stdin.readline
write = sys.stdout.write

N = int(readline())
ropes = []

for i in range(N):
    ropes.append(int(readline()))

ropes.sort()
max_weight = 0

for idx, capacity in enumerate(ropes):
    counts = N - idx
    crnt_max_weight = capacity * counts
    max_weight = max(max_weight, crnt_max_weight)

write(str(max_weight) + '\n')