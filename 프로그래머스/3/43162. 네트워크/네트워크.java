class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        int[][] adj = computers;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, visited, adj);
            }
        }

        return answer;
    }

    private void dfs(int crnt, boolean[] visited, int[][] adj) {
        visited[crnt] = true;
        for (int i = 0; i < adj[crnt].length; i++) {
            if (adj[crnt][i] == 1 && !visited[i]) {
                dfs(i, visited, adj);
            }
        }
    }
}