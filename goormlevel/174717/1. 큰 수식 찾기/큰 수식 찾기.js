// Run by Node.js
const readline = require('readline');

const strToExp = (str) => {
	for (let i = 0; i < str.length; i++) {
		if (str[i].isInteger()){
			
		}
	}
}


(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	for await (const line of rl) {
		let [exp1, exp2] = line.split(' ');
		
		console.log(Math.max(eval(exp1), eval(exp2)));
		
		rl.close();
	}
	
	process.exit();
})();

