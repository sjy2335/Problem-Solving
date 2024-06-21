function solution(n, lost, reserve) {
    
    reserve.forEach((item, idx, reserve) => {
        const lostIdx = lost.indexOf(item);
        if (lostIdx !== -1) {
            reserve.splice(idx, 1);
            lost.splice(lostIdx, 1);
        }
    })
    
    
    let lostCnt = lost.length;
    lost.sort((a, b) => a-b); // 명시하지 않았으면 정렬되어 있지 않을 수도 있다.
    
    for (let i = 0; i < lost.length; i++) {
        let crnt = lost[i];
        for (const j of [crnt-1, crnt, crnt+1]) {
            const idx = reserve.indexOf(j);
            if (idx !== -1) {
                reserve.splice(idx, 1);
                lostCnt--;
                break;
            }
        }
    }
    
    return n-lostCnt;
}