import java.util.*;

class Solution {
    private int N, M;
    private int count;

    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length; 

        // 자물쇠의 홈 개수 세기
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) count++;
            }
        }

        // 키를 회전시키면서 확인
        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            if (isMatch(key, lock)) return true;
        }

        return false;
    }

    private int[][] rotate(int[][] original) {
        int[][] rotated = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = original[i][j];
            }
        }

        return rotated;
    }

    private boolean isMatch(int[][] key, int[][] lock) {
        // 키를 자물쇠 왼쪽 위에 놓는 경우부터 확인하기 위해 -M + 1부터 시작
        for (int i = -M + 1; i < N; i++) {
            for (int j = -M + 1; j < N; j++) {
                
                int matched = 0;
                boolean valid = true;

                // 키와 자물쇠 맞는지 확인
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        int x = i + k;
                        int y = j + l;

                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            if (lock[x][y] == 1 && key[k][l] == 1) valid = false;
                            if (lock[x][y] == 0 && key[k][l] == 1) matched++;
                        }
                    }
                }

                if (matched == count && valid) return true;
            }
        }
        
        return false;
    }
}