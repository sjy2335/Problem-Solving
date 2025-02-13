import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int prevExit = Integer.MIN_VALUE;
        int count = 0;
        
        for (int[] route: routes) {
            int enter = route[0];
            int exit = route[1];
            if (enter > prevExit) {
                count++;
                prevExit = exit;
            }
        }
        
        return count;
    }
}