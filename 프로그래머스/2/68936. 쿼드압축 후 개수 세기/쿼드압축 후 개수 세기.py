def solution(arr):
    answer = [0, 0] # Please.. do not forget to initialize
    
    def count(r_pos, c_pos, length):
        nonlocal answer
        
        target = None
        valid = True
        
        for i in range(r_pos, r_pos + length):
            for j in range(c_pos, c_pos + length):
                if target == None:
                    target = arr[i][j]
                elif arr[i][j] != target:
                    valid = False
                    break

        if valid:
            answer[target] += 1
        else:
            length //= 2
            for i in range(2):
                for j in range(2):
                    next_r = r_pos + length * i
                    next_c = c_pos + length * j
                    count(next_r, next_c, length)
            
        
    count(0, 0, len(arr))
    
    return answer