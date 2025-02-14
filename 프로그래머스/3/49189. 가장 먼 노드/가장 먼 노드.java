import java.util.*;

class Solution {
    
    private class Node {
        int index;
        int distance;
        
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    
    public int solution(int n, int[][] edge) {
       	
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }        
        
        for (int[] e: edge) {
            adj[e[0] - 1].add(e[1] - 1);
            adj[e[1] - 1].add(e[0] - 1);
        }
        
        int[] dist = new int[n];
        
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.distance, n2.distance));
        pq.add(new Node(0, 0));
        
        while (!pq.isEmpty()) {
            Node crnt = pq.poll();
            
            for (int node: adj[crnt.index]) {
                if (node != 0 && dist[node] == 0) {
    	            pq.add(new Node(node, crnt.distance + 1));
	                dist[node] = crnt.distance + 1;
                }
            }
        }
        
        int max = Arrays.stream(dist).max().getAsInt();
        
        return (int) Arrays.stream(dist).filter(i -> i == max).count();
    }
}