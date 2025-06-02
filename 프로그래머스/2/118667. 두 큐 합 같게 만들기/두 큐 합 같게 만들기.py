from collections import deque

def solution(queue1, queue2):
    answer = -2
    
    sum1, sum2 = sum(queue1), sum(queue2)    
    queue1, queue2 = deque(queue1), deque(queue2)
    
    max_count = (len(queue1) + len(queue2)) * 3
    
    count = 0
    while queue1 and queue2:
        if count > max_count:
            break
            
        if sum1 == sum2:
            return count
        
        elif sum1 > sum2:
            tmp = queue1.popleft()
            queue2.append(tmp)
            sum1 -= tmp
            sum2 += tmp
            
        else:
            tmp = queue2.popleft()
            queue1.append(tmp)
            sum1 += tmp
            sum2 -= tmp    
            
        count += 1
    
    return -1