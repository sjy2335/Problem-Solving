import sys
from collections import deque

def main():
    # Board
    N = int(sys.stdin.readline()) # 2 ~ 100 -> 4 ~ 10000 칸
    arr = [[0] * N for _ in range(N)]

    # Apples
    K = int(sys.stdin.readline())
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        arr[x - 1][y - 1] = 1

    # Snake's Movement Information
    L = int(sys.stdin.readline())
    info = {}
    for _ in range(L):
        time, direction = sys.stdin.readline().split()
        time = int(time)
        info[time] = direction

    # Directions - Right, Down, Left, Up
    dr = [0, 1, 0, -1]
    dc = [1, 0, -1, 0]

    # Current Head
    r, c = 0, 0
    arr[r][c] = 2 # Check as body existed at first

    # Deque for bodies
    bodies = deque()
    bodies.append([r, c])

    def collided():
        if r < 0 or c < 0 or r >= N or c >= N: # collision with walls
            return True
        if arr[r][c] == 2: # collision with body
            return True
        return False


    t = 0 # time
    d = 0 # direction

    def turn_clockwise():
        # 0 1 2 3 0 ...
        nonlocal d
        d = (d + 1) % 4
    def turn_counter_clockwise():
        # 3 2 1 0 3
        nonlocal d
        d = (d + 3) % 4 # Unlike C/C++ or Java, Python can also use (d - 1) % 4

    while True:
        t += 1
        r += dr[d]
        c += dc[d]

        if collided(): break

        was_apple = arr[r][c] == 1
        arr[r][c] = 2               # Check Body Existence to Array
        bodies.append([r, c])       # Add body into queue

        if t in info:  # Turn Direction
            if info[t] == "D":
                turn_clockwise()
            else:
                turn_counter_clockwise()

        if was_apple:
            continue
        else:
            t_r, t_c = bodies.popleft()
            arr[t_r][t_c] = 0

    print(t)

if __name__ == "__main__":
    main()