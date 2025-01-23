import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        for (int h = 1; h < (int) Math.sqrt(sum) + 1; h++) {
            if (sum % h == 0) {
                int w = sum / h;
                if ((w-2) * (h-2) == yellow) return new int[]{w, h};
            }
        }
        
        return answer;
    }
}