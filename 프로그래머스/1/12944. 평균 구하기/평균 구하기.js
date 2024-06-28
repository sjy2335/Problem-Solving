function solution(arr) {
    return arr.reduce((acc, item) => acc+Number(item), 0) / arr.length;
}