function solution(citations) {
    citations.sort((a, b) => a - b);
    let n = citations.length;
    let h = 0;
    for (let i = 0; i < n; i++) {
        h = n - i;
        if (citations[i] >= h) {return h;}
    }
    return 0;
}