"""
DP 상태 정의
i번째 행에서 가능한 상태는 0 (안 둠) 1 (왼쪽에 사자) 2 (오른쪽에 사자)
따라서 dp[i][s]로 정의 가능

이번 행에 아무것도 안 두는 경우
dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]

이번 행 왼쪽에만 두는 경우
dp[i][1] = dp[i-1][0] + dp[i-1][2]

이번 행 오른쪽에만 두는 경우
dp[i][2] = dp[i-1][0] + dp[i-1][1]

나머지 연산 합동식의 성질 가지므로 미리 적용하기

시간복잡도 O(N)
공간복잡도 O(1) - 이전 행에만 의존하므로 1차원 배열 사용 가능, 상수
"""

import sys
input = sys.stdin.readline

def count_zoo(N, mod):
    # dp[s]: 현재 열의 상태 s에 대한 경우의 수
    dp = [1, 1, 1] # 처음은 1
    
    for _ in range(N-1):
        a, b, c = dp
        na = (a + b + c) % mod
        nb = (a + c) % mod
        nc = (a + b) % mod
        dp = [na, nb, nc]
    
    return(sum(dp) % mod)
        

def main():
    N = int(input().strip())
    result = count_zoo(N, 9901)
    print(result)

if __name__ == "__main__":
    main()