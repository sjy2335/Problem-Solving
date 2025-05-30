def solution(info, edges):
    from collections import defaultdict

    graph = defaultdict(list)
    for parent, child in edges:
        graph[parent].append(child)

    max_sheep = 0

    def dfs(curr, sheep, wolf, can_go):
        nonlocal max_sheep

        if info[curr] == 0:
            sheep += 1
        else:
            wolf += 1

        if sheep <= wolf:
            return

        max_sheep = max(max_sheep, sheep)

        next_nodes = can_go + graph[curr]
        next_nodes.remove(curr)

        for next_node in next_nodes:
            dfs(next_node, sheep, wolf, next_nodes[:])

    dfs(0, 0, 0, [0])

    return max_sheep