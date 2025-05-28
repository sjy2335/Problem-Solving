from collections import deque

def solution(m, n, board):
    answer = 0
    
    board = [list(row) for row in board]
    
    while True:
        
        target = [[False] * n for _ in range(m)]
        
        for i in range(m - 1):
            for j in range(n - 1):
                if board[i][j] == 'X':
                    continue
                if board[i][j] == board[i][j + 1] == board[i + 1][j] == board[i + 1][j + 1]:
                    target[i][j] = True
                    target[i][j + 1] = True
                    target[i + 1][j] = True
                    target[i + 1][j + 1] = True
        
        count = 0
        
        for j in range(n):
            dq = deque()
            
            for i in reversed(range(m)):
                if not target[i][j]:
                    dq.append(board[i][j])
            
            for i in reversed(range(m)):
                if dq:
                    board[i][j] = dq.popleft()
                else:
                    board[i][j] = 'X'
                    count += 1
        
        if count == 0:
            break
        
        answer += count
        
    
    return answer