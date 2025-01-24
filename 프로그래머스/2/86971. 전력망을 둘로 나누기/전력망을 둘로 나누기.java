import java.util.*;

class Solution {
    
    int N;
    boolean[] visited;
    ArrayList<Integer>[] adj;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        N = n;
        adj = new ArrayList[N+1]; // 1 ~ N
        
        // wires의 i번째를 제외할 때 절댓값 구하고 비교
        for (int i = 0; i < n-1; i++) {
            
            visited = new boolean[N+1]; // 1 ~ N
            for (int j = 1; j <= n; j++) {
                adj[j] = new ArrayList<>();
            }
            
            
            for (int j = 0; j < n-1; j++) {
                if (i == j) continue; // i번째 제외
                
                int n1 = wires[j][0], n2 = wires[j][1];
                adj[n1].add(n2);
                adj[n2].add(n1);
            }
            
			int cnt1 = dfs(1);
            int cnt2 = 0;
            
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    cnt2 = dfs(j);
                    break;
                }
            }
            
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            
        }
        
        return answer;
    }
    
    private int dfs(int start) {
        visited[start] = true;
        int count = 1;
        
        for (int next: adj[start]) {
            if (visited[next]) continue;
			count += dfs(next);
        }
        
        return count;
    }
}