import math

# 23 = 16 + 4 + 2 + 1

X = int(input().strip())

shortest = 64
length_sum = 64
count = 1

while length_sum > X:
    shortest /= 2
    if length_sum - shortest >= X:
        length_sum -= shortest
    else:
        count += 1

print(count)