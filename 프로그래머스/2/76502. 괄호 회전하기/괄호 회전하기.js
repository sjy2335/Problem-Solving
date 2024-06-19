function solution(s) {
    let answer = 0;

    const input = [...s];
    
    for (let i = 0; i < input.length ; i++) {
        const checkStack = [];
        let top = -1;
        let isCorrect = true;
        
        for (const item of input) {
            if (['(', '[', '{'].includes(item)) {
                checkStack.push(item);
                top++;
                continue;
            }
            if (top === -1) { 
                isCorrect = false; 
                break;
            }
            if (item === ')') {
                if (checkStack[top] === '(') {top--; checkStack.pop(); continue;}
                isCorrect = false; 
                break;
            }
            if (item === ']') {
                if (checkStack[top] === '[') {top--; checkStack.pop(); continue;}
                isCorrect = false; 
                break;
            }
            if (item === '}') {
                if (checkStack[top] === '{') {top--; checkStack.pop(); continue;}
                isCorrect = false; 
                break;
            }
        }
        
        if (top === -1 && isCorrect) answer++;
        
        input.push(input.shift());
    }
    
    
    return answer;
}