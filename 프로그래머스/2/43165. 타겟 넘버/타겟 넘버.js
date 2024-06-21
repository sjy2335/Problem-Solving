function solution(numbers, target) {
    let memo = {};

    function dfs(index, currentSum) {
        if (index === numbers.length) {
            return currentSum === target ? 1 : 0;
        }

        let memoKey = `${index},${currentSum}`;
        if (memoKey in memo) {
            return memo[memoKey];
        }

        let add = dfs(index + 1, currentSum + numbers[index]);
        let subtract = dfs(index + 1, currentSum - numbers[index]);

        memo[memoKey] = add + subtract;
        return memo[memoKey];
    }

    return dfs(0, 0);
}


// // BFS - 시간 초과....... 다른 방법은 없나
// function solution(numbers, target) {
//     let answer = 0;

//     const queue = [[0, 0]];
    
//     while (queue.length !== 0) {
//         const [crrSum, idx] = queue.shift();

//         if (idx === numbers.length) {
//             if (crrSum === target) answer++;
//         }
        
//         else {
//             queue.push([crrSum + numbers[idx], idx+1]);
//             queue.push([crrSum - numbers[idx], idx+1]);
//         }
        
//     } 
    
//     return answer;
// }