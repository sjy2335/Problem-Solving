def solution(n, wires):
    """
    n: 송전탑 개수, 2 이상 100 이하
    wires: 전선 정보, n-1개
    
    - 모든 wire 없애는 경우에 대해 나눠진 2개 그래프 탐색
        - 시간복잡도: O(n * n) -> n이 100이므로 1만 이하, 0.1ms 이하 예상
    """
    
    # 인접 행렬 구성
    adj = [set() for _ in range(n)]
    for s, e in wires:
        adj[s - 1].add(e - 1)
        adj[e - 1].add(s - 1)        
    
    answer = 100
    
    def dfs(start):
        cnt = 1
        for nxt in adj[start]:
            if nxt in visited:
                continue
            visited.add(nxt)
            cnt += dfs(nxt)
        return cnt
    
    # 모든 간선 한번씩 없애보면서 그래프 탐색 2번씩 수행
    for s, e in wires:
        visited = set()
        visited.add(s - 1)
        visited.add(e - 1)
        adj[s - 1].remove(e - 1)
        adj[e - 1].remove(s - 1)
        answer = min(answer, abs(dfs(s - 1) - dfs(e - 1)))
        adj[s - 1].add(e - 1)
        adj[e - 1].add(s - 1)
        
    return answer