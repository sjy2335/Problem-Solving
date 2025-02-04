

// 단순화해서 생각해보기 (원형이 아닌 일렬이라면)
// 단순화된 규칙에서 점화식 세우기 max(dp[i-1], dp[i-2] + money[i])
        
class Solution {
    public int solution(int[] money) {
        
        int N = money.length;
        int answer = 0;
		
        // 첫번째 집을 털고, 마지막 집 털지 않는 경우
        int[] dp1 = new int[N + 1];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }
        dp1[N - 1] = dp1[N - 2];
        
        // 첫번째 집 털지 않고, 마지막 집 털어도 되는 경우
        int[] dp2 = new int[money.length + 1];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        
        return Math.max(dp1[N - 1], dp2[N - 1]);
    }
}