const readline = require('readline');

let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

let input;
let sum = 0;
let i = 0;
let T;

rl.on('line', (line) => {
	input = line.split(' ');
	if (i === 0) {i++; T = parseInt(input);}
	else {
		let [n, m] = [input[0], input[2]].map(Number);
		let tmp;
		switch (input[1]) {
			case '+':
				tmp = n + m;
				break;
			case '-':
				tmp = n - m;
				break;
			case '/':
				tmp = Math.floor(n / m);
				break;
			case '*':
				tmp = n * m;
				break;
			default:
				break;
		}
		sum += tmp;
		i++;
	}
	if (i > T) rl.close();
});

rl.on('close', () => {
	console.log(sum);
})