import java.util.*;

class Solution {
    public int solution(int[] order) {
        int N = order.length;
        int[] container = new int[N];
        for (int i = 0; i < N; i++) {
            container[order[i] - 1] = i + 1;
        }
        
        // 3 4 2 1 5
        int curr = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N;) {
            if (curr != container[i]) {
                stack.push(container[i]);
                i++;
            }
            else {
                curr++;
                while (!stack.isEmpty() && stack.getFirst() == curr) {
                    stack.pop();
                    curr++;
                }
                i++;
            }
        }
        
        return curr - 1;
    }
}