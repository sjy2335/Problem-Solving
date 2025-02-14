import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] match = new int[n][n];
        for (int[] r: results) {
            int i = r[0] - 1, j = r[1] - 1;
            match[i][j] = 1;
            match[j][i] = -1;
        }
        
        for (int k = 0; k < n; k++) 
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                    if (match[i][k] == 1 && match[k][j] == 1) {
                        match[i][j] = 1;
                    }
                    if (match[i][k] == -1 && match[k][j] == -1) {
                        match[i][j] = -1;
                    }
                }
        
        int answer = 0;
        for (int[] m: match) {
            if ((int) Arrays.stream(m).filter(i -> i != 0).count() == n - 1) answer++;
        }
        
        return answer;
    }
}