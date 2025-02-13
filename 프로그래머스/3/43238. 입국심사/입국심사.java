import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int max = Arrays.stream(times).max().getAsInt();
        
        long left = 0;
        long right = (long) n * (long) max;
        
        while (left <= right) {
            long mid = (left + right) / 2L;
            long people = 0L;
            for (int time: times) {
                people += mid / (long) time;
            }
            if (people >= n) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
}