// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	const input = [];
	for await (const line of rl) {
		input.push(line);
		rl.close();
	}
	solution(input[0])
	process.exit();
})();

function solution(N) {
	let number = BigInt(1);

	for(let i = 1; i <= N; i++) {
		number *= BigInt(i);
	}

	while(number > 10) {
		let sum = BigInt(0);
		const temp = number.toString();

		for(let i = 0; i < temp.length; i++) {
			sum += BigInt(temp[i]);
		}

		number = sum;
	}

	console.log(number.toString());
}
