import sys
rl = sys.stdin.readline

N, M = map(int, rl().split())

sequence = []
buffer = [] # for output optim

def dfs():
    if len(sequence) == M:
        buffer.append(' '.join(map(str,sequence)))
        return
    for i in range(1, N + 1):
        sequence.append(i)
        dfs()
        sequence.pop()
    
dfs()

print('\n'.join(buffer))