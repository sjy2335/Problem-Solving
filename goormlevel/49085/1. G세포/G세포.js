// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let N;
	for await (const line of rl) {
		N = parseInt(line);
		rl.close();
	}
	let cnt = 0;
	let times = [];
	
	while (N > 0) {
		let size = 1;
		let time = 0;
		while (true) {
			if (size * 2 > N) {
				N -= size;
				times.unshift(time);
				cnt++;
				break;
			}
			size *= 2;
			time ++;
		}
	}
	console.log(cnt);
	console.log(times.join(' '));
	process.exit();
})();
