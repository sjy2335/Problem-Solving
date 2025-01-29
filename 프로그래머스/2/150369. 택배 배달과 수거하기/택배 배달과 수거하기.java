import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        for (int i = n - 1; i >= 0;) {
            
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            
            transport(cap, deliveries, i);
            transport(cap, pickups, i);
            
            answer += 2 * (i + 1);
            
        }
        
        return answer;
    }
    
    private void transport(int cap, int[] stocks, int idx) {
        while (idx >= 0 && cap > 0) {
            
            if (stocks[idx] > cap) {
                stocks[idx] -= cap;
                break;
            } 
            
            cap -= stocks[idx];
            stocks[idx] = 0;
            idx--;

        }
    }
    
}