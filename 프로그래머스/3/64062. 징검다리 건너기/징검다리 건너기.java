import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < stones.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst(); // 범위 벗어난 것 제거
            }
            
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            
            deque.add(i);
            
            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peek()]);
            }
        }
        
        return answer;
    }
}