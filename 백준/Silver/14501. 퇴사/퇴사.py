import sys
rl = sys.stdin.readline

N = int(rl())
T = []
P = []

for i in range(N):
    t, p = map(int, rl().split())
    T.append(t)
    P.append(p)
    
cache = [0] * (N + 1) # Maximum profit considering untill ith

for i in range(N):
    # Case 1: Skip ith
    cache[i + 1] = max(cache[i + 1], cache[i])

    # Case 2: Do ith
    nxt = i + T[i]
    if nxt <= N:
        cache[nxt] = max(cache[nxt], cache[i] + P[i])

print(cache[N])


# # This is also possible (Iteration with Backward States)
# # In this case, cache array refers to the maximum profit earnable in ith to Nth date (after ith)
#  for i in range(N - 1, -1, -1):
#     if i + T[i] <= N:
#         cache[i] = max(cache[i + 1], P[i] + cache[i + T[i]]) # Do -> Today's + After's maximum profit
#     else:
#         cache[i] = cache[i + 1] # Skip -> maximum profit from i + 1th date

# print(cache[0])


# # Using Recursion (& Backward States)
# cache = [-1] * (N + 1)

# def solve(i):
#     # base case
#     if i >= N:
#         return 0
    
#     # already computed
#     if cache[i] != -1:
#         return cache[i]
    
#     # case 1: skip
#     res = solve(i + 1)
    
#     # case 2: take
#     if i + T[i] <= N:
#         res = max(res, P[i] + solve(i + T[i]))
    
#     cache[i] = res
#     return res

# print(solve(0))
