function solution(priorities, location) {
    
    priorities = priorities.map((priority, index) => [index, priority]);
    
    let cnt = 0;
    while (priorities.length) {
        if (priorities.some(item => item[1] > priorities[0][1])) {
            // 더 높은 우선순위 있으면 뒤로 보냄
            priorities.push(priorities.shift());
        } else { // 가장 높은 우선순위면 바로 실행
            let tmp = priorities.shift();
            cnt++;
            if (tmp[0] === location) return cnt;
        }
    }
}