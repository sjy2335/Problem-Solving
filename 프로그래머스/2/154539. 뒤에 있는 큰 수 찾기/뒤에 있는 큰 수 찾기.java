import java.util.*;

class Solution {
    
    private class Node {
        int index;
        int value;
        
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > stack.getFirst().value) {
                Node node = stack.pop();
                answer[node.index] = numbers[i];
            }
            stack.push(new Node(i, numbers[i]));
        }
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.index] = -1;
        }
        
        return answer;
    }
}