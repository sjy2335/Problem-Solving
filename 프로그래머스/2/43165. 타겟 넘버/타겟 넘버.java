class Solution {
    private static int N;
	private static int answer;
    private static int[] numbers;
    private static int target;
	
    private void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == target) answer++;
        } else {
            dfs(idx + 1, sum + numbers[idx]);
            dfs(idx + 1, sum - numbers[idx]);
        }
    }
    
    public int solution(int[] ns, int t) {
        N = ns.length;
        answer = 0;
        numbers = ns;
        target = t;
        
        dfs(0, 0);
        
        return answer;
    }
}