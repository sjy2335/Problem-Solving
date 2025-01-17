import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
        	int idx = moves[i] - 1;
            int shape = 0;
            for (int j = 0; j < board.length; j++) {
            	if (board[j][idx] != 0) {
                	shape = board[j][idx];
                    board[j][idx] = 0;
                    break;
                }
            }
            
            if (shape == 0) {
                continue;
            }
            
            if (stack.isEmpty() || stack.peek() != shape) {
                stack.push(shape);
            } else {
            	stack.pop();
                answer += 2;
            }
        }
        return answer;
    }
}