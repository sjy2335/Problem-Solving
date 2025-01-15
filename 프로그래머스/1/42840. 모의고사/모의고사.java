import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] counts = new int[3];
        
        int[] firstMethod = {1, 2, 3, 4, 5};
        int[] secondMethod = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdMethod = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstMethod[i % 5]) counts[0]++;
            if (answers[i] == secondMethod[i % 8]) counts[1]++;
            if (answers[i] == thirdMethod[i % 10]) counts[2]++;
        }
        
        int maxScore = Arrays.stream(counts).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (counts[i] == maxScore) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}