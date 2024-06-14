function solution(cacheSize, cities) {
    if (cacheSize === 0) return cities.length * 5;
    var answer = 0;
    
    cities = cities.map((s) => s.toLowerCase())
    let cache = [];
    
    cities.map((city) => {
        let idx = cache.indexOf(city);
        if (idx === -1) {
            if (cache.length >= cacheSize) cache.shift();
            cache.push(city);
            answer += 5;
        }
        else {
            cache.splice(idx, 1);
            cache.push(city);
            answer++;
        }
        //console.log(cache);
    })
    
    return answer;
}