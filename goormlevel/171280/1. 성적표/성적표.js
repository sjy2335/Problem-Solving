// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let i = 0;
	let N, M;
	let subjects;
	for await (const line of rl) {
		if (i === 0) {
			[N, M] = line.split(' ').map(Number); 
			subjects = Array.from(new Array(M+1), () => new Array());
		}
		else {
			let [c, s] = line.split(' ').map(Number);
			subjects[c].push(s);
		}
		i++;
		if (i > N) rl.close();
	}
	
	let maxAvg = 0;
	let maxAvgIdx = 0;
	for (let j = 1; j <= M; j++) {
		if (subjects[j].length === 0) continue;
		let avg = subjects[j].reduce((acc, crnt) => acc + crnt, 0) / subjects[j].length;
		[maxAvg, maxAvgIdx] = maxAvg < avg ? [avg, j] : [maxAvg, maxAvgIdx];
	}
	console.log(maxAvgIdx);
	
	process.exit();
})();
