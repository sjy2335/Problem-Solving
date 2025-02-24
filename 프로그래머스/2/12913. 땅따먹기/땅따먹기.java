import java.util.*;

class Solution {
    int solution(int[][] land) {
        int N = land.length;
        
        for (int i = 1; i < N; i++) {
            int max1 = -1, idx1 = -1, max2 = -1, idx2 = -1;
            
            for (int j = 0; j < 4; j++) {
                if (land[i - 1][j] > max2) {
                    max2 = land[i - 1][j];
                    idx2 = j;
                }
                if (max1 < max2) {
                    int tmp = max1;
                    int tmpIdx = idx1;
                    
                    max1 = max2;
                    idx1 = idx2;
                    
                    max2 = tmp;
                    idx2 = tmpIdx;
                }
            }
            
            for (int j = 0; j < 4; j++) {
                land[i][j] += j != idx1 ? max1 : max2;
            }
        }
        
        return Arrays.stream(land[N - 1]).max().getAsInt();
        
    }
}