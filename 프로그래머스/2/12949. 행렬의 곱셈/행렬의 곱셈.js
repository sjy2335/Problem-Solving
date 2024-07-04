function solution(arr1, arr2) {
    const [R, C] = [arr1.length, arr2[0].length];
    const M = arr2.length;
    const result = Array.from({length:R}, () => new Array(C).fill(0));

    for(let i = 0; i < R; i++){
        for (let j = 0; j < C; j++){
            for (let k = 0; k < M; k++) {
                result[i][j] += arr1[i][k] * arr2[k][j]
            }
        }
    }
    
    return result;
}