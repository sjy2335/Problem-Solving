function solution(id_list, report, k) {
    
    const reportMap = {};
    const answerMap = {};
    id_list.forEach(id =>{
        reportMap[id] = [];
        answerMap[id] = 0;
    })
    
    report.forEach(detail => {
        const [reporter, reportee] = detail.split(' ');
        if (!reportMap[reportee].includes(reporter)) {
            reportMap[reportee].push(reporter);
        }
    })
    
    for (const tmpList of Object.values(reportMap)) {
        if (tmpList.length < k) continue;
        tmpList.forEach(id => answerMap[id]++);
    }
    
    return Object.values(answerMap);
}