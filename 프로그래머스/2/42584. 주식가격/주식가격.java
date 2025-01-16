import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int[] solution(int[] prices) {
        
        int length = prices.length;
        int[] answer = new int[length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int i = 1; i < length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = length - 1 - j;
        }
        
        return answer;
    }
}