function solution(elements) {
    var answer = new Set();
    
    for (var i = 1; i <= elements.length; i++) {
        for (var j = 0; j < elements.length; j++) {
            answer.add(elements.slice(0, i).reduce((acc, crnt) => acc + crnt, 0));
            elements.push(elements.shift());
        }
    }
    
    return answer.size;
}