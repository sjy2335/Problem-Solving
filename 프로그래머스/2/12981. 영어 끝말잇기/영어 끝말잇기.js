function solution(n, words) {
    
    var map = new Map();
    var i = 1;
    var cnt = 1;
    var prevChar = words[0][0];
    
    for (var j = 0; j < words.length; j++) {
        if (map.has(words[j]) || words[j][0] != prevChar) {
            return [i, cnt];
        }
        else {
            map.set(words[j], true);
            prevChar = words[j][words[j].length-1];
            if (i === n) {i = 1; cnt++;}
            else i ++;
        }
    }


    return [0, 0];
}