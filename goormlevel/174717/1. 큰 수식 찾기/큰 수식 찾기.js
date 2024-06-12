// Run by Node.js
const readline = require('readline');

let symbols = ['+', '-', '*'];

const convStrExp = (S) => {
	var acc = "";
	var exp = [];
	[...S].forEach((c, idx) => {
		if (symbols.includes(c)) {
			exp.push(acc);
			acc = "";
			exp.push(c);
		} else if (idx === S.length-1) {
			exp.push(acc+c);
		} else {
			acc = acc + c;
		}
	})
	// console.log(exp);
	return exp;
}

const solution = (S) => {
	var exp = convStrExp(S);

	for (let i = 0; i < exp.length; i++) {
		if (exp[i] === '*') {
			var tmp = Number(exp[i-1] * exp[i+1]);
			exp[i+1] = tmp;
			exp.splice(i-1, 2);
			i--;
		}
	}
	
	for (let i = 0; i < exp.length; i++) {
		if (exp[i] === '+') {
			var tmp = Number(exp[i-1]) + Number(exp[i+1]);
			exp[i+1] = tmp;
			exp.splice(i-1, 2);
			i--;
		}
		if (exp[i] === '-') {
			var tmp = Number(exp[i-1] - exp[i+1]);
			exp[i+1] = tmp;
			exp.splice(i-1, 2);
			i--;
		}
	}

	return exp[0];
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let [exp1, exp2] = line.split(' ');
		
		console.log(Math.max(solution(exp1), solution(exp2)));
		// console.log(Math.max(eval(exp1), eval(exp2))); // 맞긴 하지만 쓰면 안되는 코드
		
		rl.close();
	}
	
	process.exit();
})();

