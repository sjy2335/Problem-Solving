function solution(want, number, discount) {
    var answer = 0;
    const wantMap = new Map();
    const buyMap = new Map();

    for (let i = 0; i < want.length; i++) {
        const [wantItem, wantNumber] = [want[i], number[i]];
        wantMap.set(wantItem, wantNumber);
        buyMap.set(wantItem, 0);
    }

    
    for (let i = 0; i < discount.length - 9; i++) {
        let flag = true;

        for (let j = i; j-i < 10; j++) {
            
            const discountKey = discount[j];
            const numberBuy = buyMap.get(discountKey);
            
            if (numberBuy === undefined) {
                flag = false;
                break;
            } 
            
            buyMap.set(discountKey, numberBuy + 1);
            
            if (buyMap.get(discountKey) > wantMap.get(discountKey)) {
                flag = false;
                break;
            }
        }
        
        if (flag) answer++;
        buyMap.forEach((value, key, buyMap) => buyMap.set(key, 0));
    }
    
    return answer;
}