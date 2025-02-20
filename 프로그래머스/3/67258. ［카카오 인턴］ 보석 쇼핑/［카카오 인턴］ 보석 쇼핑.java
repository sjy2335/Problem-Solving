import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int[] answer = {1, gems.length};
        int length = gems.length;
        
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemMap = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        while (right < gems.length) {
            while (gemSet.size() != gemMap.size() && right < gems.length) {
                String gem = gems[right++];
                gemMap.put(gem, gemMap.getOrDefault(gem, 0) + 1);
            }
            
            while (gemSet.size() == gemMap.size() && left <= right) {
                String gem = gems[left++];
                int tmp = gemMap.get(gem);
                if (tmp == 1) gemMap.remove(gem);
                else gemMap.put(gem, tmp - 1);
            }
            
            if (right - left + 1 < length) {
                length = right - left + 1;
                answer[0] = left;
                answer[1] = right;
            }
        }
        
        return answer;
    }
}