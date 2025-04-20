import sys

N, M = map(int, sys.stdin.readline().split())
row, col, dir = map(int, sys.stdin.readline().split())
rooms = []
for i in range(N):
    rooms.append(list(map(int, sys.stdin.readline().split())))

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1] # 북, 동, 남, 서

def isValidPos(row, col):
    if row < 0 or col < 0 or row >= N or col >= M:
        return False
    return True

def uncleanedExists(row, col):
    for i in range(4):
        nr = row + dr[i]
        nc = col + dc[i]
        if isValidPos(nr, nc) and rooms[nr][nc] == 0:
            return True
    return False

def turn(dir):
    """
    dir은 0, 1, 2, 3이 북, 동, 남, 서 -> 3 더하고 4로 나눈 나머지가 반시계방향 90도
    """
    return (dir + 3) % 4

cleaned = 0

# 0이 빈 칸, 1이 벽, 2는 이미 청소한 칸으로 정의
while True:
    if rooms[row][col] == 0:
        rooms[row][col] = 2
        cleaned += 1

    if uncleanedExists(row, col):
        for i in range(4):
            dir = turn(dir)
            nr = row + dr[dir]
            nc = col + dc[dir]
            if not isValidPos(nr, nc):
                continue
            if rooms[nr][nc] == 0:
                row = nr
                col = nc
                break
    else:
        row -= dr[dir]
        col -= dc[dir]
        if not isValidPos(row, col):
            break
        if rooms[row][col] == 1:
            break

print(cleaned)