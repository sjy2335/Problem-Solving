function solution(numbers, hand) {
    var answer = '';
    
    // 왼손 엄지, 오른손 엄지 선언 및 초기화
    let leftThumb = [3, 0];
    let rightThumb = [3, 2];
    
    // 각 숫자 클릭 처리 로직 - 거리 같은 경우는 hand 변수 사용
    numbers.forEach(number => {
        const idx = number-1;
        
        let row = Math.floor(idx / 3);
        let column = idx % 3;
        if (idx === -1) [row, column] = [3, 1];
        
        if ([0, 3, 6].includes(idx)) {
            answer += 'L';
            leftThumb = [row, column];
        }
        
        else if ([2, 5, 8].includes(idx)) {
            answer += 'R';
            rightThumb = [row, column];
        }
        
        else {
            const leftDist = Math.abs(leftThumb[0] - row) + Math.abs(leftThumb[1] - column);
            const rightDist = Math.abs(rightThumb[0] - row) + Math.abs(rightThumb[1] - column);

            if (leftDist < rightDist) {
                answer += 'L';
                leftThumb = [row, column];
            }
            else if (rightDist < leftDist) {
                answer += 'R';
                rightThumb = [row, column];
            }
            else {
                if (hand === "right") {
                    answer += 'R';
                    rightThumb = [row, column];
                }
                else {
                    answer += 'L';
                    leftThumb = [row, column];
                }
            }
        }
    })
    
    return answer;
}