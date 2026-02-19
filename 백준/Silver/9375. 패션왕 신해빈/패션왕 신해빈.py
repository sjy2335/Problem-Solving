import sys

rl = sys.stdin.readline
wr = sys.stdout.write

T = int(rl().strip())

for _ in range(T):
    n = int(rl().strip())
    counts = dict()
    
    for _ in range(n):
        _, kind = rl().split()
        counts[kind] = counts.get(kind, 0) + 1
    
    ans = 1
    for c in counts.values():
        ans *= (c + 1) # Not wearing & Each
    ans -= 1 # Wearing nothing
    
    wr(str(ans) + '\n')