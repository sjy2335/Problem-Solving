// Run by Node.js
const readline = require('readline');

let N, Q;
let board;

const toPairs = (triangle) => {
	let pairs = [];
	for (let i = 0; i < 6; i+=2) {
		pairs.push([triangle[i], triangle[i+1]]);
	}
	return pairs;
}

const solution = (pairs) => {
	let sum = 0;
	pairs.sort((a, b) => a[0] - b[0] || a[1] - b[1]);
	// console.log(pairs);
	
	if (pairs[0][0] === pairs[1][0]) {
		if (pairs[2][1] === pairs[0][1]) {
			for (let i = 0; i <= pairs[2][0] - pairs[0][0]; i++) {
				for (let j = pairs[0][1]; j <= pairs[1][1]-i; j++) {
					sum += board[pairs[0][0]+i][j];
				}
			}
		}
		if (pairs[2][1] === pairs[1][1]) {
			for (let i = 0; i <= pairs[2][0] - pairs[0][0]; i++) {
				for (let j = pairs[0][1] + i; j <= pairs[1][1]; j++) {
					sum += board[pairs[0][0]+i][j];
				}
			}
		}
	}
	if (pairs[1][0] === pairs[2][0]) {
		if (pairs[0][1] === pairs[1][1]) {
			for (let i = 0; i <= pairs[2][0] - pairs[0][0]; i++) {
				for (let j = 0; j <= i; j++) {
					sum += board[pairs[0][0]+i][pairs[0][1]+j];
				}
			}
		} 
		if (pairs[0][1] === pairs[2][1]) {
			for (let i = 0; i <= pairs[2][0] - pairs[0][0]; i++) {
				for (let j = 0; j <= i; j++) {
					sum += board[pairs[0][0]+i][pairs[0][1]-j];
				}
			}
		}
	}
	
	console.log(sum);
} 


(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let i = 0;
	
	for await (const line of rl) {
		if (i === 0) {
			[N, Q] = line.split(' ').map(Number);
			board = new Array(N);
		} 
		else if (i <= N) board[i-1] = line.split(' ').map(Number);
		else if (i <= N+Q) { 
			let triangle = line.split(' ').map((n) => Number(n)-1);
			solution(toPairs(triangle))
		}
		else rl.close();
		i++;
	}
	

	process.exit();
})();
