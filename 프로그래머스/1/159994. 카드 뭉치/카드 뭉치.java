import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> firstDeque = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> secondDeque = new ArrayDeque<>(Arrays.asList(cards2));
        
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            if (!firstDeque.isEmpty() && firstDeque.getFirst().equals(word)) {
                firstDeque.poll();
                continue;
            }
            else if (!secondDeque.isEmpty() && secondDeque.getFirst().equals(word)) {
                secondDeque.poll();
                continue;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}