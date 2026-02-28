def solution(n):
    
    triangle = [[0] * i for i in range(1, n + 1)]
    dr = (1, 0, -1)
    dc = (0, 1, -1)
    
    r, c, num = -1, 0, 0
    
    for step, counts in enumerate(range(n, 0, -1)):
        for _ in range(counts):
            r += dr[step % 3]
            c += dc[step % 3]
            num += 1
            triangle[r][c] = num
            
    return [item for row in triangle for item in row]