import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Set<Integer> validNumbers = new HashSet<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.add(number);
                maxHeap.add(number);
                validNumbers.add(number);
            } else if (command.equals("D")) {
                if (number == 1) {
                    while (!maxHeap.isEmpty() && !validNumbers.contains(maxHeap.peek())) {
                        maxHeap.poll();
                    }
                    if (!maxHeap.isEmpty()) {
                        int maxValue = maxHeap.poll();
                        validNumbers.remove(maxValue);
                    }
                } else if (number == -1) {
                    while (!minHeap.isEmpty() && !validNumbers.contains(minHeap.peek())) {
                        minHeap.poll();
                    }
                    if (!minHeap.isEmpty()) {
                        int minValue = minHeap.poll();
                        validNumbers.remove(minValue);
                    }
                }
            }
        }

        while (!minHeap.isEmpty() && !validNumbers.contains(minHeap.peek())) {
            minHeap.poll();
        }
        while (!maxHeap.isEmpty() && !validNumbers.contains(maxHeap.peek())) {
            maxHeap.poll();
        }

        if (validNumbers.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}