function preprocess(records) {
    // 레코드 전처리
    records.forEach((str, idx, records) => {
        records[idx] = str.split(" ");
    })
    
    //정렬 (차량번호 -> 시간 기준)
    records.sort(([timeA, numA, logA], [timeB, numB, logB]) => {
        return numA - numB || timeA - timeB;
    })
    
    records.forEach((record, idx, records) => {
        records[idx][0] = records[idx][0].split(':');
    })

    
    return records;
}

function solution([baseTime, baseFee, unitTime, unitFee], records) {
    var answer = [];
    
    records = preprocess(records);

    var accTime = 0;
    
    for (var i = 0; i < records.length; i++) {
        var [[hour1, min1], car1, log1] = records[i];
        hour1 = parseInt(hour1);
        min1 = parseInt(min1);
        
        if (i == records.length-1) {
            if (log1 === 'IN') {
                accTime += (23 - hour1) * 60 + 59 - min1;
                answer.push(accTime);
            } else {
                answer.push(accTime);
            }
            break;
        }
        
        var [[hour2, min2], car2, log2] = records[i+1];
        hour2 = parseInt(hour2);
        min2 = parseInt(min2);
        
        if (car1 === car2 && log1 === 'IN') {
            accTime += (hour2 - hour1) * 60 + min2 - min1;
        } 
        if (car1 != car2 && log1 === 'IN') { // 다음 차가 다른데 현재 차가 IN
            accTime += (23 - hour1) * 60 + 59 - min1;
            answer.push(accTime);
            accTime = 0;
        } 
        if (car1 != car2 && log1 === 'OUT') { // 다음 차가 다른데 현재 차가 OUT
            answer.push(accTime);
            accTime = 0;
        }
    }
    
    return answer.map(a => {
        if (a <= baseTime) return baseFee;
        else return baseFee + Math.ceil((a - baseTime) / unitTime) * unitFee
    })
}