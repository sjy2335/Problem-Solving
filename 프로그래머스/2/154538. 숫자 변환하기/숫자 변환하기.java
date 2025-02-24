import java.util.*;

class Solution {
    
    
    public int solution(int x, int y, int n) {
        Set<Integer> visited = new HashSet<>();
        Deque<int[]> dq = new ArrayDeque<>();
        
        visited.add(x);
        dq.add(new int[]{x, 0});
        
        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int curr = node[0];
            int count = node[1];
            
            if (curr == y) return count;
            
            int next = curr + n;
            if (!visited.contains(next) && next <= y) {
                visited.add(next);
                dq.add(new int[]{next, count + 1});
            }
            
            next = curr * 2;
            if (!visited.contains(next) && next <= y) {
                visited.add(next);
                dq.add(new int[]{next, count + 1});
            }
            
            next = curr * 3;
            if (!visited.contains(next) && next <= y) {
                visited.add(next);
                dq.add(new int[]{next, count + 1});
            }
            
        }
        
        return -1;
    }
}