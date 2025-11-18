""" 
# Using Queue itself
If the number of pizzas is M, O(M) 
M <= 10^6 
If we assume that it takes 1 sec for 10^8 operations, it would be 0.01 sec


# Improvements?
"""

import sys
from collections import deque

rl = sys.stdin.readline

N = int(rl())

requests = list(map(int, rl().split()))
results = [0 for _ in requests]

dq = deque(i for i in range(N))
count = 0
while dq:
    count += 1
    popped = dq.popleft()
    requests[popped] -= 1
    if requests[popped] > 0:
        dq.append(popped)
    else:
        results[popped] = count
    
print(' '.join(map(str, results)))
