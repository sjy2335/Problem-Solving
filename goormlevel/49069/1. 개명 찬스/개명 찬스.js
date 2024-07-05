const readline = require('readline');

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.question('', (input) => {
	let index = -1;

	if (input.length === 2) {
		index = input.charCodeAt(0) - input.charCodeAt(1);

		if (index < 0) {
			console.log(input.charAt(0));
		} else {
			console.log(input.charAt(1));
		}

		rl.close();
		return;
	}

	for (let i = 0; i < input.length - 1; i++) {
		if (input.charAt(i) > input.charAt(i + 1)) {
			index = i;
			break;
		} else if (input.charAt(i) === input.charAt(i + 1)) {
			index = -2;
		}
	}

	if (index < 0) {
		console.log(input.substring(0, input.length - 1));
		rl.close();
		return;
	}

	console.log(input.substring(0, index) + input.substring(index + 1, input.length));
	rl.close();
});