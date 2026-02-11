import sys
rl = sys.stdin.readline

num_list = list(rl().strip())

num_list.sort(reverse=True)

print(''.join(num_list))