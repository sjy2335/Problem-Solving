import java.util.*;

class Solution {
    
    private List<List<Integer>> candidates;
    private Set<Set<Integer>> uniqueCombinations;
    private boolean[] visited;

    
    public int solution(String[] user_id, String[] banned_id) {
        int N = banned_id.length;
        int M = user_id.length;
        
        candidates = new ArrayList<>();
        for (int i = 0; i < N; i++) candidates.add(new ArrayList<>());
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isMatch(user_id[j], banned_id[i])) {
                    candidates.get(i).add(j);
                }
            }
        }
        
        uniqueCombinations = new HashSet<>();
        visited = new boolean[M]; 
        
        findCombinations(0, new HashSet<>(), N);
        return uniqueCombinations.size();
    }
    
    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void findCombinations(int depth, Set<Integer> currentSet, int N) {
        if (depth == N) {
            uniqueCombinations.add(new HashSet<>(currentSet));
            return;
        }

        for (int idx : candidates.get(depth)) {
            if (!visited[idx]) {
                visited[idx] = true;
                currentSet.add(idx);
                findCombinations(depth + 1, currentSet, N);
                currentSet.remove(idx);
                visited[idx] = false;
            }
        }
    }

}