import java.util.*;

class Solution {
    
    private static int[] counts;
    
    public int solution(int n) {
		counts = new int[n+1];
        counts[1] = 1;
        counts[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            counts[i] = (counts[i-1] + counts[i-2]) % 1000000007;
        }
        
        return counts[n];
    }
}