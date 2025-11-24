import sys
from collections import Counter, deque

rl = sys.stdin.readline

T = int(rl().strip())

for _ in range(T):
    N, M = map(int, rl().split())
    
    vals = list(map(int, rl().split()))
    val_counts = Counter(vals)
    
    q = deque([index, weight] for index, weight in enumerate(vals))
    cnt = 0
    
    while q:
        index, weight = q.popleft()
        rotate = False
        
        for w in val_counts:
            if w > weight: 
                rotate = True
                break
                
        if rotate:
            q.append([index, weight])
            
        else:
            cnt += 1
            val_counts[weight] -= 1
            
            if index == M: 
                print(cnt)
                break
                
            if val_counts[weight] == 0: 
                val_counts.pop(weight)