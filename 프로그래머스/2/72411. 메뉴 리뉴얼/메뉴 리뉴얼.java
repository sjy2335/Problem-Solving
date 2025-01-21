import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

class Solution {

	// 메뉴 개수 : (가능한 조합 : 주문된 횟수)
	private static Map<Integer, Map<String, Integer>> courseMap;
            
    public String[] solution(String[] orders, int[] course) {
        
        courseMap = new HashMap<>();
		ArrayList<String> answer = new ArrayList<>();
        
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }
        
        for (String order: orders) {
            char[] menus = order.toCharArray();
            Arrays.sort(menus);
            generateCombinations(0, menus, "");
        }
        
        for (Map<String, Integer> countMap : courseMap.values()) {
            countMap.values()
                .stream()
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(cnt -> countMap
                           .entrySet()
                           .stream()
                           .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                		   .forEach(entry -> answer.add(entry.getKey())));
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
         
    }
    
    
    public static void generateCombinations(int idx, char[] menus, String result) {
        
        if (courseMap.containsKey(result.length())) {
            Map<String, Integer> countMap = courseMap.get(result.length());
            countMap.put(result, countMap.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx; i < menus.length; i++) {
            generateCombinations(i + 1, menus, result + menus[i]);
        }
    }
    
}