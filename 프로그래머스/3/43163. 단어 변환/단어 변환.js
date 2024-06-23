function solution(begin, target, words) {
    
    const visited = {};
    words.forEach(word => visited[word] = false);
    
    const queue = [];
    queue.push([begin, 0]);
    
    while (queue.length) {
        
        const [crrWord, crrStep] = queue.shift();
        if (crrWord === target) return crrStep;
        
        for (const word of words) {
            if (visited[word]) continue;
            if ([...word].filter((c, idx) => c === crrWord[idx]).length === word.length - 1) {
                queue.push([word, crrStep+1]);
                visited[word] = true;
            }
        }
    }
    
    return 0;
}