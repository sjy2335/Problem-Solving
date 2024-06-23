function solution(n, k) {
    let answer = 0;
    const kNumList = n.toString(k).split('');
    // 순회하면서 왼쪽, 오른쪽 조건이 맞으면 소수인지 판별해서 더하기
    
    let numJoined = ""; 
    kNumList.forEach((c, idx) => {
        if (c === '0') {
            if (numJoined !== "" && checkPrime(parseInt(numJoined))) answer++;
            numJoined = "";
        } 
        else if (idx === kNumList.length - 1) {
            numJoined += c;
            if (checkPrime(parseInt(numJoined))) answer++;
        }
        else {
            numJoined += c;
        }
    })
    
    return answer;
    
}

function checkPrime(N) {
    if (N === 1) return false;
    for (let i = 2; i <= Math.sqrt(N); i++) {
        if (N % i === 0) return false; 
    }
    return true;
}