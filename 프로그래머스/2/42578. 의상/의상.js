function solution(clothes) {
    
    const clothMap = clothes.reduce((map, [cloth, type]) => {
        map[type] = map[type] || [];
        map[type].push(cloth);
        return map;
    }, {});
    
    
    let answer = Object.keys(clothMap).reduce((acc, key) => {
        return acc * (clothMap[key].length + 1)
    }, 1)
    
    return answer-1;
}