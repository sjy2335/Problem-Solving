// Run by Node.js
const readline = require('readline');

const mirrorChar1 = ['b', 'd', 'i', 'l', 'm', 'n', 'o', 'p', 'q', 's', 'z', 'u', 'v', 'w', 'x'];
const mirrorChar2 = ['d', 'b', 'i', 'l', 'm', 'n', 'o', 'q', 'p', 'z', 's', 'u', 'v', 'w', 'x'];

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let i = 0;
	let N;
	for await (const line of rl) {
		if (i === 0) N = Number(line);
		else {
			solution(line);
		}
		i++;
		if (i === N+1)		rl.close();
	}
	
	process.exit();
})();

function solution(word) {
	for (let i = 0; i < Math.floor(word.length / 2); i++) {
		let c1 = word[i];
		let c2 = word[word.length-1-i];
		if (mirrorChar1.indexOf(c1) != mirrorChar2.indexOf(c2) || mirrorChar1.indexOf(c1) === -1 || mirrorChar2.indexOf(c2) === -1) {
			console.log("Normal");
			return;
		}
	}
	
	if (word.length === 1) {
		if (['i', 'l', 'm', 'n', 'o', 'u', 'v', 'w', 'x'].includes(word[0])) console.log("Mirror");
		else console.log("Normal");
		return;
	}
	
	console.log("Mirror");
	return;
}