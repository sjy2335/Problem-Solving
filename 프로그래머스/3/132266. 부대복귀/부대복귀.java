import java.util.*;

class Solution {
    
    private int N, S;
    private List<List<Integer>> adj;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        N = n;
        S = sources.length;
        
        generateAdjacentList(roads);
        
        int[] answer = new int[S];
        
        for (int i = 0; i < S; i++) answer[i] = bfs(sources[i] - 1, destination - 1);

        return answer;
    }
    
    private void generateAdjacentList(int[][] roads) {
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        
        for (int[] road: roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    
    private int bfs(int source, int destination) {
        boolean[] visited = new boolean[N];
        Deque<int[]> deque = new ArrayDeque<>();
        
        deque.add(new int[]{source, 0});
        visited[source] = true;
        
        while (!deque.isEmpty()) {
            int[] currNode = deque.poll();
            int curr = currNode[0];
            int currDist = currNode[1];
            
            if (curr == destination) return currDist;
            
            for (int next: adj.get(curr)) {
                if (visited[next]) continue;
                visited[next] = true;
                int nextDist = currDist + 1;
                deque.add(new int[]{next, nextDist});
            }
        }
        
        
        return -1;
    }
}