function solution(msg) {
    var answer = [];
    
    let dict = [' '];
    for (let i = 65; i <= 90; i++) dict.push(String.fromCharCode(i)); //console.log(dict);
    
    for (let i = 0; i < msg.length; i++) {
        let c = msg[i];
        while (dict.includes(c + msg[i+1])) {
            c = c + msg[i+1];
            i++;
        }
        answer.push(dict.indexOf(c));
        dict.push(c+msg[i+1]);
    }
    
    return answer;
}