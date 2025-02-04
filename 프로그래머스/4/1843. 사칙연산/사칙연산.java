class Solution {
    
    public int solution(String arr[]) {
		int n = (arr.length + 1) / 2;
        int[] nums = new int[n];
        char[] ops = new char[n - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else ops[i / 2] = arr[i].charAt(0);
        }
        
		int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int res1 = calculate(dpMax[i][k], dpMax[k+1][j], ops[k]);
                    int res2 = calculate(dpMax[i][k], dpMin[k+1][j], ops[k]);
                    int res3 = calculate(dpMin[i][k], dpMax[k+1][j], ops[k]);
                    int res4 = calculate(dpMin[i][k], dpMin[k+1][j], ops[k]);
                    dpMax[i][j] = Math.max(dpMax[i][j], Math.max(res1, Math.max(res2, Math.max(res3, res4))));
                    dpMin[i][j] = Math.min(dpMin[i][j], Math.min(res1, Math.min(res2, Math.min(res3, res4))));
                }
            }
        }
		return dpMax[0][n - 1];
    }
    
    private int calculate(int n1, int n2, char op) {
        if (op == '+') return n1 + n2;
        return n1 - n2;
    }
}