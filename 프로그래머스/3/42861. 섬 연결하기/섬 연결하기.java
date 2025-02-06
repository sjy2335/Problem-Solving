import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] edges) {
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        parent = new int[n];
        Arrays.fill(parent, -1);
        
        int answer = 0;
        int count = 0;
        
		for (int[] edge: edges){
            if (union(edge[0], edge[1])) {
                answer += edge[2];
                if (++count > n) break;
            }
        }
        
        return answer;
    }
    
    private boolean union(int u, int v) {
        int up = find(u);
        int vp = find(v);
        if (up == vp) return false;
        parent[up] = vp;
        return true;
    }
    
    private int find(int i) {
        if (parent[i] < 0) return i;
        return parent[i] = find(parent[i]);
    }
}