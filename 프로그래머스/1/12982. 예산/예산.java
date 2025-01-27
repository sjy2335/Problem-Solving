import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int i;
        for (i = 0; i < d.length; i++) {
            if (budget >= d[i]) budget -= d[i];
            else break;
        }
        return i;
    }
}