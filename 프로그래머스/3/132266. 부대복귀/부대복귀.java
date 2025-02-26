import java.util.*;

class Solution {
    
    private List<List<Integer>> adj;
    
    // 개선 방향 -> destination에서 시작해서 sources 탐색하는 역방향 bfs!!
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        generateAdjacentList(n, roads);
        
        return bfs(n, sources, destination);
    }
    
    private void generateAdjacentList(int n, int[][] roads) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] road: roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    
    private int[] bfs(int n, int[] sources, int destination) {
        
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        boolean[] visited = new boolean[n];
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        deque.add(new int[]{destination - 1, 0});
        visited[destination - 1] = true;
        
        while (!deque.isEmpty()) {
            int[] currNode = deque.poll();
            int curr = currNode[0];
            int currDist = currNode[1];
            
            for (int i = 0; i < sources.length; i++) {
                if (sources[i] - 1 == curr) answer[i] = currDist;
            }
            
            for (int next: adj.get(curr)) {
                if (visited[next]) continue;
                visited[next] = true;
                int nextDist = currDist + 1;
                deque.add(new int[]{next, nextDist});
            }
        }
        
        return answer;
    }
}