import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        int[] arr = new int[n];
        
        int tmp = s / n;
        if (tmp == 0) return new int[]{-1};
        
        Arrays.fill(arr, tmp);
        for (int i = 0; i < s % n; i++) arr[n - 1 - i]++;
        
        return arr;
    }
}