

function solution(maps) {
    
    const dy = [-1, 0, 0, 1];
    const dx = [0, -1, 1, 0];
    
    const n = maps.length-1;
    const m = maps[0].length-1;
    const visited = Array.from({length: n+1}, () => Array(m+1).fill(false));
    
    const queue = [];
    queue.push([0, 0, 1]);
    visited[0][0] = true;
    
    while(queue.length) {
        
        const [y, x, blocks] = queue.shift();
        if (y === n && x === m) return blocks;
        
        for (let i = 0; i < 4; i++) {
            const ty = y + dy[i];
            const tx = x + dx[i];
            
            if (ty < 0 || tx < 0 || ty > n || tx > m || !maps[ty][tx] || visited[ty][tx]) continue;
            
            visited[ty][tx] = true;
            queue.push([ty, tx, blocks+1]);
            
        }
        
    }
    
    return -1;
}