"""
1
1
1
2
2
3
4
5
7
9
12

f(i) = f(i - 1) + f(i - 5)
"""

import sys
rl = sys.stdin.readline

T = int(rl().strip())

# Precompute up to max N
Ns = [int(rl()) for _ in range(T)]
maxN = max(Ns)

dp = [0, 1, 1, 1, 2, 2]

for i in range(6, maxN + 1):
    dp.append(dp[i - 1] + dp[i - 5])

for N in Ns:
    print(dp[N])