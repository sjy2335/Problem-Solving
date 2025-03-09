T = int(input())
while T > 0:
    T -= 1
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    count = 0
    while n > 0:
        n -= 1
        cx, cy, cr = map(int, input().split())
        distPow1 = (x1 - cx) ** 2 + (y1 - cy) ** 2
        distPow2 = (x2 - cx) ** 2 + (y2 - cy) ** 2
        crPow = cr ** 2
        if (distPow1 < crPow < distPow2) or (distPow2 < crPow < distPow1):
            count += 1

    print(count)