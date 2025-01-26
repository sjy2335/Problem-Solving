import java.util.*;

class Solution {
    
    private static int answer;
    private static int[][] dungeons;
    private static boolean[] visited;
    
    
    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                answer = Math.max(answer, cnt + 1);
                
                visited[i] = true;
                backtrack(k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] input) {
    
        dungeons = input;
        answer = 0;
        visited = new boolean[input.length];
        
        backtrack(k, 0);
        
        return answer;
    }
}