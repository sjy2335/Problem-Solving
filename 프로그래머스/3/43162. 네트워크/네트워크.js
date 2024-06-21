function solution(n, computers) {
    let answer = 0;
    const visited = new Array(n).fill(false);
    
    const dfs = (i) => {
        if (!visited[i]) visited[i] = true;
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