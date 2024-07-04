function solution(s) {
    const set = s.split(/\{|\}/).filter(item => item !== '' && item!==',').sort((a, b) => a.length - b.length).map(item => item.split(',').map(Number));
    
    const result = [];
    set.forEach(item => {
        result.push(item.filter(num => !result.includes(num))[0])
    })
    
    return result;
}