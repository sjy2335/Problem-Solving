import sys
from collections import deque

def calculate(a, b, op):
    if op == '+':
        return a + b
    if op == '-':
        return a - b
    if op == '*':
        return a * b
    if op == '/':
        return a / b

rl = sys.stdin.readline

N = int(rl())
inputs = list(rl().strip())
operands = {}

for i in range(N):
    key = chr(ord('A') + i)
    value = int(rl())
    operands[key] = value

stack = deque()
for c in inputs:
    if c >= 'A' and c <= 'Z':
        stack.append(operands[c])
    else:
        b = stack.pop()
        a = stack.pop()
        res = calculate(a, b, c)
        stack.append(res)

print("%0.2f"%stack.pop())