import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
		
        Arrays.sort(rocks);
        
        int left = 0, right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int removed = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++;
                    if (removed > n) break;
                } 
                else prev = rock;
            }

            if (distance - prev < mid) removed++;

            if (removed > n) right = mid - 1;
            else left = mid + 1;
        }

        return right;
    }
}