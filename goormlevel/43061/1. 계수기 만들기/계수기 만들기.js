// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

var N;
var maxArr;
var arr;
var K;
var i = 0;

rl.on("line", function(line) {
	if (i === 0) {
		N = parseInt(line);
	}
	else if (i === 1) {
		maxArr = line.split(' ').map(Number);
	}
	else if (i === 2) {
		arr = line.split(' ').map(Number);
	}
	else if (i === 3) {
		K = parseInt(line);
		rl.close();	
	}
	i++;
	
}).on("close", function() {
	solution();
	process.exit();
});

function solution() {
	for (var i = N-1; i >= 0; i--) {
		var tmp = arr[i];
		arr[i] = (K + tmp) % (maxArr[i] + 1); // 진법 계산과 같이
		K = Math.floor((K + tmp) / (maxArr[i] + 1));
	}
	console.log(arr.join(''));
}
