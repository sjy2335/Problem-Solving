import java.util.*;

class Solution {
    
    private static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<String> visitedNodes = new HashSet<>();
        Set<String> visitedEdges = new HashSet<>();
       
        int r = 0, c = 0;
        visitedNodes.add(r + "," + c);
        
        for (int a: arrows) {
            for (int step = 0; step < 2; step++) {
                int nr = r + dr[a];
                int nc = c + dc[a];
                
                String nodeKey = nr + "," + nc;
                String edgeKey = r + "," + c + "->" + nr + "," + nc;
                String reverseEdgeKey = nr + "," + nc + "->" + r + "," + c;
                
                if (visitedNodes.contains(nodeKey) && !visitedEdges.contains(edgeKey)) answer++;

                visitedNodes.add(nodeKey);
                visitedEdges.add(edgeKey);
                visitedEdges.add(reverseEdgeKey);
                
                r = nr;
                c = nc;
            }
        }
        
        return answer;
    }
}