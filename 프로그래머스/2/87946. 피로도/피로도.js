function solution(k, dungeons) {
    let answer = 0;
    const visited = Array.from({length:dungeons.length}, () => false);
    
    function DFS(hp, cnt) {
        for (let i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= hp) {
                visited[i] = true;
                DFS(hp - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
    
    DFS(k, 0);
    
    return answer;
 
}