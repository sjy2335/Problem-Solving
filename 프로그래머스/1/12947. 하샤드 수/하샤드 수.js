function solution(x) {

    return (x % x.toString().split('').reduce((acc, crr) => acc+Number(crr), 0)) === 0 ? true : false;
}