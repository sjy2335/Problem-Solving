import sys

neg, zero, pos = 0, 0, 0
arr = []

def all_equal(row, col, length):
    t = arr[row][col]
    for i in range(row, row + length):
        for j in range(col, col + length):
            if arr[i][j] != t:
                return False

    return True

def add_count(num):
    global neg, zero, pos
    if num == 1:
        pos += 1
    elif num == -1:
        neg += 1
    else:
        zero += 1
    return

def check_paper(row, col, length):
    num = arr[row][col]
    if length == 1:
        add_count(num)
    elif all_equal(row, col, length):
        add_count(num)
    else:
        length //= 3
        for _ in range(3):
            next_col = col
            for _ in range(3):
                check_paper(row, next_col, length)
                next_col += length
            row += length

N = int(sys.stdin.readline())

for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))


check_paper(0, 0, N)

print(f"{neg}\n{zero}\n{pos}")