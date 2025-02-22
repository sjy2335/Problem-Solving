import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> rightMap = new HashMap<>();
        Set<Integer> leftSet = new HashSet<>();
        
        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }
        
        int answer = 0;
        for (int t : topping) {
            leftSet.add(t);
            rightMap.put(t, rightMap.get(t) - 1);
            
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }
            
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}