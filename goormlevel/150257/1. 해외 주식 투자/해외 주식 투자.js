// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let i = 0;
	let N;
	let stocks = [];
	
	for await (const line of rl) {
		if (i === 0) {
			N = Number(line);
		}
		else {
			let [v, w] = line.split(' ');
			v = parseFloat(v);
			w = Number(w);
			stocks.push([i, Math.floor(v * w * 10) / 10]);
		}
		i++;
		if (i > N) rl.close();
	}
	stocks.sort((a, b) => b[1]-a[1] || a[0]-b[0]);
	console.log(stocks.map(crnt => crnt[0]).join(' '));
	
	//process.exit();
})();
