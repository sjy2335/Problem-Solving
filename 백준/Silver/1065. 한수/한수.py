import sys
rl = sys.stdin.readline

N = int(rl())
answer = 0

for num in range(1, N + 1):
    is_hansu = True
    previous = num % 10
    num //= 10
    current = num % 10
    diff = current - previous
    
    while num > 0:
        current = num % 10
        if (current - previous) != diff:
            is_hansu = False
            break
        previous = current
        num //= 10
    
    if is_hansu:
        answer += 1

print(answer)