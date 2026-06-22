def solution(N, number):
    
    # set of nums that can be made by using "number" i times
    dp = [set() for _ in range(9)]
    
    for i in range(1, 9):
        
        tmp = N
        for _ in range(i - 1):
            tmp = (tmp * 10) + N
        dp[i].add(tmp)
        
        for j in range(1, i):
            for n1 in dp[j]:
                for n2 in dp[i - j]:
                    dp[i].add(n1 + n2)
                    dp[i].add(n1 - n2)
                    dp[i].add(n1 * n2)
                    if n2 == 0: continue
                    dp[i].add(n1 // n2)
        
        if number in dp[i]:
            return i
        
    return -1