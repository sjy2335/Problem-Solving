// Run by Node.js
const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const input = [];

rl.on("line", function(line) {
	input.push(line);
}).on("close", function() {
	solution(input);
});

// const dx = [0, -1, 1, 0];
// const dy = [-1, 0, 0, 1];

function solution (lines) {
	
	for (const line of lines.slice(1)) {
		let [X, Y, N] = line.split(' ');
		
		if (N < Math.abs(X) + Math.abs(Y)) {
			console.log("NO");
		}
		else if ((Math.abs(X) + Math.abs(Y) - N) % 2) {
			console.log("NO");
		}
		else console.log("YES");
		
	}
}