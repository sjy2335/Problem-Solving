function solution(skill, skill_trees) {
    var answer = 0;
    
    const skill_input = skill_trees.map(item => item.split(''));
    
    skill_input.forEach(item => {
        const queue = [...skill];
        let invalid_flag = false;
        item.forEach(c => {
            if (queue.indexOf(c) === 0) queue.shift();
            else if (queue.includes(c)) invalid_flag = true;
        })
        if (!invalid_flag) answer++;
    })
    
    return answer;
}