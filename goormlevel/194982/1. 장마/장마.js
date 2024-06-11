// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let i = 0;
	let heights;
	let days;
	
	let N = 0;
	let M = 0;
	
	for await (const line of rl) {
		
		if (i === 0) {
			[N, M] = line.split(' ').map(Number);
			days = new Array(N).fill(0);
		}
		else if (i === 1) {
			heights = line.split(' ').map(Number);
		}
		else {
			const [s, e] = line.split(' ').map(Number);
			
			for (let j = s-1; j <= e-1; j++) {
				heights[j]++;
				days[j] = i-1; // i가 2부터 시작됨
			}
			
			if ((i-1) % 3 === 0) {
				heights.forEach((h, idx, array) => {
					if ((i-1) - days[idx] < 3) array[idx]--;
				})
			}
		}
		
		i++;
		
		if (i === M+2) {
			rl.close();
		}
		
	}
	
	console.log(heights.join(' '));
	
	process.exit();
})();
