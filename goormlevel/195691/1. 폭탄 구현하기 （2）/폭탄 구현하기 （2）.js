const readline = require('readline');

let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

let input;
let i = 0;
let N, K;
let matrix;
let diffMatrix;
let max = 0;

const dy = [-1, 0, 0, 0, 1]; // 세번째 값은 현재 위치
const dx = [0, -1, 0, 1, 0];

rl.on('line', (line) => {
	input = line;
	if (i === 0) {
		N = parseInt(input.split(' ')[0]);
		K = parseInt(input.split(' ')[1]);
		// console.log(N, K);
		matrix = new Array(N);
		diffMatrix = new Array(N);
		// console.log(diffMatrix);
	}
	
	else if (i <= N) {
		matrix[i-1] = input.split(' ');
		diffMatrix[i-1] = new Array(N).fill(0);
		//console.log(matrix);
	}
	
	else {
		//console.log("bombing called")
		const [y, x] = input.split(' ').map(Number);
		bombing(y-1, x-1);
	}
	
	i++;
	
	if (i > N + K) rl.close();
	
});

rl.on('close', () => {
	//console.log(matrix);
	console.log(max);
})

function bombing(y, x) {
	for (let j = 0; j < 5; j++) {
		let y2 = y + dy[j];
		let x2 = x + dx[j];
		if (y2 < 0 || x2 < 0 || y2 >= N || x2 >= N || matrix[y2][x2] === '#') continue;
		if (matrix[y2][x2] === '@') diffMatrix[y2][x2] += 2;
		else if (matrix[y2][x2] === '0') diffMatrix[y2][x2] ++;
		max = max < diffMatrix[y2][x2] ? diffMatrix[y2][x2] : max;
	}
}