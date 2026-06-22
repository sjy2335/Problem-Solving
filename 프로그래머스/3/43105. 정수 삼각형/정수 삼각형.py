def solution(triangle):
    N = len(triangle)
    
    for i in range(1, N):
        for j in range(i + 1):
            n1 = triangle[i - 1][j - 1] if j > 0 else 0
            n2 = triangle[i - 1][j] if j < i else 0
            triangle[i][j] += max(n1, n2)
            
    return max(triangle[N - 1])
            
        
    