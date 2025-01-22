class Solution {
    
    private static boolean[] visited;
	private static int[][] adj;
    
    private static void dfs(int crnt) {
        visited[crnt] = true;
        for (int i = 0; i < adj[crnt].length; i++) {
            if (adj[crnt][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        adj = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
}