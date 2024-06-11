// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		var [N, M] = line.split(' ');

		N = parseInt(N);
		M = parseInt(M);
		
		var ans = Math.floor( (7 / 100 * N) / (N + M) * 100 * 100 ) / 100;
		
		if (ans.toString().length === 3) console.log(ans+'0');
		else if (ans.toString().length === 1) console.log(ans+'.00');
		else console.log(ans);
		
		rl.close();
	}
	
	process.exit();
})();