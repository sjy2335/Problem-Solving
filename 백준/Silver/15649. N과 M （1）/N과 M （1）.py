"""
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 **수열**을 모두 사전 순으로 증가하게 출력

파이썬 permutation 사용도 가능하긴 하겠지만 직접 해보기
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
visited = [False] * (N + 1) # 1부터 N까지만 사용

def permute(count, seq):
    if count == M:
        print(' '.join(map(str, seq)))
        return
    
    for i in range(1, N + 1):
        if visited[i]: continue
        visited[i] = True
        seq.append(i)
        permute(count + 1, seq)
        visited[i] = False
        seq.pop()

permute(0, [])