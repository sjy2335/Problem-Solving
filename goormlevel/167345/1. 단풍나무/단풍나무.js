// Run by Node.js
const readline = require('readline');

let N;
let arr;
let diffArr;

const dx = [-1, 0, 0, 1];
const dy = [0, -1, 1, 0];

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let i = -1;
	for await (const line of rl) {
		if (i === -1) {
			N = parseInt(line);
			arr = new Array(N);
		} 
		else {
			arr[i] = line.split(' ').map(Number);
		}
		i++;
		if (i === N) rl.close();
	}
	solution();
	process.exit();
})();

function solution() {
	var cnt = 0;
	while (arraySum(arr)) {
		diffArr = Array.from(Array(N), () => Array(N).fill(0));
		
		for (let i = 0; i < N; i++) {
			for (let j = 0; j < N; j++) {
				if (arr[i][j] === 0) {
					for (let k = 0; k < 4; k++) {
						if (i + dx[k] < 0 || i + dx[k] >= N || j + dy[k] < 0 || j + dy[k] >= N) continue;
						diffArr[i+dx[k]][j+dy[k]]++;
					}
				}
			}
		}
		
		for (let i = 0; i < N; i++) {
			for (let j = 0; j < N; j++) {
				arr[i][j] = arr[i][j] < diffArr[i][j] ? 0 : arr[i][j] - diffArr[i][j];
			}
		}
		
		cnt++;
	}
	console.log(cnt);
}

function arraySum(arr) {
	return arr.reduce((acc, crnt) => acc + crnt.reduce((acc, crnt) => acc + crnt, 0), 0);
}