function solution(phone_book) {
    
    // 방법 1. 전체 phone_book 배열 정렬(문자열 기준) 후 이후 값이 이전 값으로 시작하는지 확인
    
    // 방법 2. 해시 맵 사용 => 우선 이거로 풀어보자.
    const hashMap = new Map();
    for (const number of phone_book) {
        hashMap.set(number, true); // 값이 있는지 없는지 판단하고 싶을 때, 그냥 true 넣어주자.
    }
    
    for (const number of phone_book) {
        for (let i = 0; i < number.length; i++) {
            if (hashMap.get(number.slice(0, i)) === true) return false;
        }
    }
    
    return true;
}