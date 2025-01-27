import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        
        int h = triangle.length;

        if (h == 1) return triangle[0][0];
        
        int[][] dp = new int[h][];
        for (int i = 0; i < h; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
		dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < h; i++) {
            
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
        
		return Arrays.stream(dp[h-1]).max().getAsInt();
        
    }
}