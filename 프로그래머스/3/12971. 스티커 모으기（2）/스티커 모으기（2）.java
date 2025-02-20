class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int N = sticker.length;
        if (N == 1) return sticker[0];

        int[][] cache = new int[N - 1][2];
        
        // 0 ~ N-2 스티커만 사용하는 경우  
        cache[0][0] = 0;
        cache[0][1] = sticker[0];
        for (int i = 1; i < N - 1; i++) {
            cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1]);
            cache[i][1] = cache[i - 1][0] + sticker[i];
        }
        
        answer = Math.max(cache[N - 2][0], cache[N - 2][1]);
        
        cache = new int[N - 1][2];
        // 1 ~ N-1 스티커만 사용하는 경우  
        cache[0][0] = 0;
        cache[0][1] = sticker[1];
        for (int i = 1; i < N - 1; i++) {
            cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1]);
            cache[i][1] = cache[i - 1][0] + sticker[i + 1];
        }
        
        answer = Math.max(answer, Math.max(cache[N - 2][0], cache[N - 2][1]));        
        
        return answer;
    }
}