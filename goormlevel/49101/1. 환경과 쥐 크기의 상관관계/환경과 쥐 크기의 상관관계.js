// Run by Node.js
const readline = require('readline');

const solution = (weights) => {
	const cntArr = new Array(100001).fill(0);
	for (let i = 0; i < weights.length; i++) {
		for (let j = -2; j < 3; j++) {
			if (weights[i]+j <= 0 || weights[i]+j > 100000) continue;
			cntArr[weights[i]+j]++
		}
	}

	return cntArr.indexOf(Math.max(...cntArr));
}

let N;

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let i = 0;
	let weightsA;
	let weightsB;
	
	for await (const line of rl) {
		if (i === 0) N = Number(line);
		if (i === 1) {
			weightsA = line.split(' ').map(Number);
		}
		if (i === 2) {
			weightsB = line.split(' ').map(Number);
		}
		i++;
		if (i === 3) rl.close();
	}
	
	let ansA = solution(weightsA);
	let ansB = solution(weightsB);
	
	console.log(ansA + ' ' + ansB);
	console.log(ansA > ansB ? "good" : "bad");
	
	process.exit();
})();
