import java.util.*;

class Solution {
    
    private static int INF = Integer.MAX_VALUE;
    
    private static class Node {
        int dest, cost;
        
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        
        ArrayList<Node>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge: road) {
            int n1 = edge[0], n2 = edge[1], t = edge[2];
            adj[n1].add(new Node(n2, t));
            adj[n2].add(new Node(n1, t));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            
            Node crnt = pq.poll();
            if (dist[crnt.dest] < crnt.cost) 
                continue;
            
            for (Node next: adj[crnt.dest]) {
                int nextCost = crnt.cost + next.cost;
                if (dist[next.dest] > nextCost) {
                    dist[next.dest] = nextCost;
                    pq.add(new Node(next.dest, nextCost));
                }
            }
            
        }
        
        int answer = 0;
		for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}