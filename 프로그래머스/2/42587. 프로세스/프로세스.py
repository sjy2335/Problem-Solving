import heapq
from collections import deque

def solution(priorities, location):
    wq = deque()
    pq = []
    
    for idx, priority in enumerate(priorities):
        wq.append((idx, priority))
        heapq.heappush(pq, -priority) # negative value for descending order of absolute value
        
    answer = 0
    while True:
        if wq[0][1] < -pq[0]: # revert to positive value and compare
            wq.append(wq.popleft())
        else:
            num = wq.popleft()[0]
            heapq.heappop(pq)
            answer += 1
            if num == location:
                break
    
    return answer