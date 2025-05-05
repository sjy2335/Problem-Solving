import sys

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))

stack = list()
answer = [-1] * N
top = -1

for i in range(N):
    while top >= 0 and A[stack[top]] < A[i]:
        answer[stack.pop()] = A[i]
        top -= 1
    stack.append(i)
    top += 1

print(" ".join(str(n) for n in answer))