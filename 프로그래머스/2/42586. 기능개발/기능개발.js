function solution(progresses, speeds) {
    var answer = [];
    
    while (progresses.length) {
        for (let i = 0; i < progresses.length; i++) {
            progresses[i] += speeds[i];
            if (progresses[i] > 100) progresses[i] = 100;
        }
        let cnt = 0;
        while (progresses[0] === 100) {
            progresses.shift();
            speeds.shift();
            cnt++;
        }
        if (cnt > 0) answer.push(cnt);
    }
    
    
    return answer;
}