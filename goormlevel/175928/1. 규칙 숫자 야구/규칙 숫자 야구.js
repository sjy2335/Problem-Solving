const readline = require('readline');

function ballMethod(my, sbf) {
	let temp = [];
	for(let a = 0; a < 4; a++) {
		if(sbf[a] !== "s") {
			temp.push(my[a]);
		}
	}
	temp.unshift(temp.pop());
	my = my.split('');
	for(let b = 0; b < 4; b++) {
		if(sbf[b] !== "s") {
			my[b] = temp.shift();
		}
	}
	my = my.join('');
	
	return my;
}

function baseball(correct, my) {
	let already = true;
	for(let i = 1; already; i++) {
		//규칙 1 sbf검사
		let sbf = {};
		let isExistB = false;
		for(let c = 0; c<4; c++) {
			for(let j = 0; j<4; j++) {
				if(my[c] == correct[j]) {
					if(c == j) {
						sbf[c] = "s"
					} else {
						sbf[c] = "b";
						isExistB = true;
					}
				}
			}
			if(sbf[c] == null) {
				sbf[c] = "f"
				my = my.split('');
				my[c] = String((my[c] * 1 + 1) % 10);
				while(my.indexOf(my[c]) !== my.lastIndexOf(my[c])) {
					my[c] = String((my[c] * 1 + 1) % 10);
				}
				my = my.join('');
			};
		}
		
		if(isExistB) {
			my = ballMethod(my, sbf);
		}
		//완성의 경우 반환
		if(sbf[0]+sbf[1]+sbf[2]+sbf[3] == "ssss") return i;
	}
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	let correct = null;
	let my = null;
	for await (const line of rl) {
		correct == null ?	correct = line : my = line;
		
		if(correct != null && my != null) {
			rl.close();
		}
	}
	
	console.log(baseball(correct, my));
	
	process.exit();
})();