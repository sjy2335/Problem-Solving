// Run by Node.js
const readline = require('readline');

const solution = (N) => {
	return [...Array(N)].map((v, r) => [...Array(N)].map((v, c) => {
		return	r * N + c + 1;
	}));
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let i = 0;
	let N;
	
	for await (const line of rl) {
		N = Number(line);
	}
	
	let ans = solution(N);
	for (let i = 0; i < N; i++) {
		console.log(ans[i].join(' '))
	}
	process.exit();
})();
