// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let N, T;
	for await (const line of rl) {
		[N, T] = line.split(' ');
		rl.close();
	}
	for (let i = 2; i < 17; i++) {
		//console.log(T);
		if (parseInt(N).toString(i).toUpperCase() === T) {
			console.log(i);
			break;
		}
	}
	process.exit();
})();
