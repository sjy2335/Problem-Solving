import java.util.*;

class Solution {
    
    private final int LENGTH = 5;
    private List<List<Integer>> combinations = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
    
        generateCombinations(n, 1, new ArrayList<>());
        
        int answer = 0;
        
        for (List<Integer> combination: combinations) {
            
            Set<Integer> set = new HashSet<>(combination);
            boolean valid = true;
            
            for (int i = 0; i < q.length; i++) {
	            int match = 0;
                for (int qNum: q[i]) {
                    if (set.contains(qNum)) match++;
                }
                if (match != ans[i]) valid = false;
            }
            
            if (valid) answer++;
        }
        
    	return answer;
    }
    
    private void generateCombinations(int n, int start, List<Integer> current) {
        if (current.size() == LENGTH) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}