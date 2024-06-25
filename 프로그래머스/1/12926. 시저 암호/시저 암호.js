function solution(s, n) {
    return [...s].map(c => {
        if (c === ' ') return ' ';
        let code = c.charCodeAt();
        if(code >= 97) {
            code += n;
            if (code > 122) code -= 26;
        } else {
            code += n;
            if (code > 90) code -= 26;
        }
        return String.fromCharCode(code);
    }).join('');
}