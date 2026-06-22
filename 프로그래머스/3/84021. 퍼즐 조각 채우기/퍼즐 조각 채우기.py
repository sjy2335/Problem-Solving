from collections import deque

dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]


def find_blocks(board, target):
    n = len(board)
    visited = [[False] * n for _ in range(n)]
    result = []

    for r in range(n):
        for c in range(n):
            if board[r][c] != target or visited[r][c]:
                continue

            queue = deque([(r, c)])
            visited[r][c] = True
            block = []

            while queue:
                current_r, current_c = queue.popleft()
                block.append((current_r, current_c))

                for direction in range(4):
                    nr = current_r + dr[direction]
                    nc = current_c + dc[direction]

                    if nr < 0 or nc < 0 or nr >= n or nc >= n:
                        continue

                    if visited[nr][nc] or board[nr][nc] != target:
                        continue

                    visited[nr][nc] = True
                    queue.append((nr, nc))

            result.append(normalize_block(block))

    return result


def normalize_block(block):
    min_r = min(r for r, c in block)
    min_c = min(c for r, c in block)

    return sorted(
        (r - min_r, c - min_c)
        for r, c in block
    )


def rotate(block):
    # (r, c) -> (c, -r)로 90도 회전
    rotated = [(c, -r) for r, c in block]

    # 회전하면 좌표의 기준점과 순서가 달라지므로 다시 정규화
    return normalize_block(rotated)


def solution(game_board, table):
    empties = find_blocks(game_board, 0)
    blocks = find_blocks(table, 1)

    used = [False] * len(blocks)
    answer = 0

    for empty in empties:
        for index, block in enumerate(blocks):
            if used[index]:
                continue

            # 칸 수가 다르면 모양이 같을 수 없음
            if len(empty) != len(block):
                continue

            rotated_block = block
            matched = False

            # 0도, 90도, 180도, 270도
            for _ in range(4):
                if empty == rotated_block:
                    used[index] = True
                    answer += len(block)
                    matched = True
                    break

                rotated_block = rotate(rotated_block)

            if matched:
                break

    return answer