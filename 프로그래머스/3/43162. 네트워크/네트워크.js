function solution(n, computers) {
    let answer = 0;
    const visited = new Array(n).fill(false);
    
    const dfs = (i) => {
        if (!visited[i]) visited[i] = true;
        // 왜 j를 i+1에서 시작하면 안되지? 무방향 그래프가 아닌가?
        // 아 다른 질의 응답 보니 방향성이 있네.
        for (let j = 0; j < n; j++) {
            if (j !== i && computers[i][j] && !visited[j]) dfs(j);
        }
    }
    
    for (let i = 0; i < n; i++) {
        if (visited[i]) continue;
        dfs(i);
        answer++;
    }
    
    return answer;
}