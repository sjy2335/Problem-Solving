import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        int[] sorted = map.values()
            .stream()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        int answer = 0;
        for (int i: sorted) {
            if (k <= 0) break;
            k -= i;
            answer++;
        }
        
        return answer;
    }
}