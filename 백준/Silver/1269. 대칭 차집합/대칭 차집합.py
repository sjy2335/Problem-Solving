a_N, b_N = [int(num) for num in input().split()]

a_set = set(int(num) for num in input().split())
b_set = set(int(num) for num in input().split())

diff_set_1 = a_set - b_set
diff_set_2 = b_set - a_set

print(len(diff_set_1 | diff_set_2))