import sys
from collections import deque

rl = sys.stdin.readline
answer = []
while True:
    sentence = rl().rstrip()
    if sentence == ".": 
        break
    
    stack = deque()
    
    chars = list(sentence)
    
    for c in chars:
        if c not in ['[', ']', '(', ')']:
            continue
        if c in ['[', '(']:
            stack.append(c)
            continue
        if len(stack) == 0:
            stack.append('x')
            break
        top = stack[-1]
        if top == '[' and c == ']':
            stack.pop()
        elif top == '(' and c == ')':
            stack.pop()
        else:
            stack.append('x')
            break
                
    if len(stack) == 0:
        answer.append("yes")
    else:
        answer.append("no")

print("\n".join(answer))
   