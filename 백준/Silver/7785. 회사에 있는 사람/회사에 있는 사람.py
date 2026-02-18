import sys

rl = sys.stdin.readline
wr = sys.stdout.write

n = int(rl())
entered_set = set()
for i in range(n):
    name, action = rl().split()
    if action == 'enter':
        entered_set.add(name)
    else:
        entered_set.remove(name)

print('\n'.join(sorted(entered_set, reverse=True)))