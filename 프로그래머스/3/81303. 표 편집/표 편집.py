from collections import deque

def solution(n, k, cmds):
    prev = {i: i - 1 for i in range(n)}
    next = {i: i + 1 for i in range(n)}
    prev[0] = None
    next[n - 1] = None
    
    stack = deque()
    curr = k

    for cmd in cmds:
        parts = cmd.split()

        if parts[0] == 'D':
            X = int(parts[1])
            for _ in range(X):
                curr = next[curr]
            
        elif parts[0] == 'U':
            X = int(parts[1])
            for _ in range(X):
                curr = prev[curr]

        elif parts[0] == 'C':
            stack.append(curr)

            # 삭제 후 다음 행을 현재 위치로 설정
            prev_node, next_node = prev[curr], next[curr]

            if prev_node is not None:
                next[prev_node] = next_node
            if next_node is not None:
                prev[next_node] = prev_node

            # 마지막 행을 삭제했다면, 위쪽으로 이동
            curr = next_node if next_node is not None else prev_node

        elif parts[0] == 'Z':
            target = stack.pop()
            prev_node, next_node = prev[target], next[target]

            if prev_node is not None:
                next[prev_node] = target
            if next_node is not None:
                prev[next_node] = target

    # 결과 문자열 생성
    answer = ['O'] * n
    while stack:
        answer[stack.pop()] = 'X'
    
    return ''.join(answer)