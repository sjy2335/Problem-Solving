// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		const N = Number(line);
		if (N < 6) {
			let A = factorial(N);
			printing(A);
		} else {
			console.log('9');
		}
		rl.close();
	}
	process.exit();
})();

function factorial(N) {
	let dp = new Array(N+1).fill(0);
	dp[0] = 1;
	for (let i = 1; i <= N; i++) {
		dp[i] = i * dp[i-1];
		if (!(dp[i]%10)) dp[i] /= 10;
	}
	return dp[N];
}

function printing(A) {
	while(parseInt(A/10)){
		A = A.toString().split('').reduce((acc, crnt)=>acc+Number(crnt), 0);
	}
	console.log(A);
}
