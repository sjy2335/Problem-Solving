function solution(k, tangerine) {
    let answer = 0;
    
    const countList = {};
    
    for (let i = 0; i < tangerine.length; i++) {
        countList[tangerine[i]] = (countList[tangerine[i]] || 0) + 1;
    }
    
    const sortedArr = Object.values(countList).sort((a, b) => b- a);
    
    while(k > 0) {
        k -= sortedArr.shift();
        answer++;
    }
    
    return answer;
}