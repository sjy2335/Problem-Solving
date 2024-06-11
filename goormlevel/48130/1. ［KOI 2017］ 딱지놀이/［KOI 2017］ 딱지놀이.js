// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let i = 0;
	let arrA;
	let arrB;
	
	for await (const line of rl) {
		if (!i) {i++; continue;}
		else if (i % 2) arrA = line.split(' ').slice(1);
		else {
			arrB = line.split(' ').slice(1);
			solution(arrA, arrB);
		}
		i++;
	}
	console.log('');
	process.exit();
})();

function solution(A, B) {
	const countA = [0, 0, 0, 0];
	const countB = [0, 0, 0, 0];
	
	A.forEach(a => countA[a-1]++);
	B.forEach(b => countB[b-1]++);
	
	for (let i = 3; i >= 0; i--) {
		if (countA[i] > countB[i]) {
			console.log('A');
			return;
		}
		if (countA[i] < countB[i]) {
			console.log('B');
			return;
		}
	}
	
	console.log('D');
}