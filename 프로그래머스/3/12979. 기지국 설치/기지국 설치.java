class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int idx = 0;
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (idx < stations.length && i >= stations[idx] - w) {
                i = stations[idx] + w;
                idx++;
            } else {
                i += 2 * w;
                answer++;
            }
        }

        return answer;
    }
}