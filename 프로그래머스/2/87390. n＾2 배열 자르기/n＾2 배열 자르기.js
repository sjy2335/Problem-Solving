function solution(n, left, right) {
    const answer = [];
    
    const quoL = Math.floor(left / n);
    const remL = left % n;
    const quoR = Math.floor(right / n);
    const remR = right % n;
    
    for (let i = quoL+1; i <= quoR + 1; i++) {
        for (let j = 1; j <= n; j++) {
            if (i === quoL+1 && j <= remL) continue;
            if (i === quoR+1 && j > remR+1) break;
            if (j <= i) answer.push(i);
            else answer.push(j);
        }
    }
    
    return answer;
}