// 13:51 ~ 
import java.util.*;

class Solution {
    
    private int[][] traces;
    private int aLimit;
    private int bLimit;

    private Integer[][][] cache;
    
    
    public int solution(int[][] info, int n, int m) {
        
        traces = info;
        aLimit = n;
        bLimit = m;
        
        cache = new Integer[traces.length][n][m];
        
        int result = dp(0, 0, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dp(int idx, int aTrace, int bTrace) {
        
        if (aTrace >= aLimit || bTrace >= bLimit) return Integer.MAX_VALUE;
        if (idx == traces.length) return aTrace;
        if (cache[idx][aTrace][bTrace] != null) return cache[idx][aTrace][bTrace];
        
        int aStole = dp(idx + 1, aTrace + traces[idx][0], bTrace);
        int bStole = dp(idx + 1, aTrace, bTrace + traces[idx][1]);
        
        return cache[idx][aTrace][bTrace] = Math.min(aStole, bStole);
    }
}