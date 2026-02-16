import sys
rl = sys.stdin.readline

N = int(rl())
T = []
P = []

for i in range(N):
    t, p = map(int, rl().split())
    T.append(t)
    P.append(p)
    
cache = [0] * (N + 1) # Maximum profit considering before ith

for i in range(N):
    # Case 1: Skip ith
    cache[i + 1] = max(cache[i + 1], cache[i])

    # Case 2: Do ith
    nxt = i + T[i]
    if nxt <= N:
        cache[nxt] = max(cache[nxt], cache[i] + P[i])

print(max(cache))