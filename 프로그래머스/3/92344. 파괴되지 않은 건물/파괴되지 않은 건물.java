import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {

        int N = board.length;
        int M = board[0].length;
        int[][] deltaPrefix = new int[N + 1][M + 1];

        for (int[] cmd: skill) {
            int type = cmd[0];
            int r1 = cmd[1], c1 = cmd[2], r2 = cmd[3], c2 = cmd[4];
            int degree = type == 1 ? -1 * cmd[5] : cmd[5];
            
            deltaPrefix[r1][c1] += degree;
            deltaPrefix[r1][c2 + 1] -= degree;
            deltaPrefix[r2 + 1][c1] -= degree;
            deltaPrefix[r2 + 1][c2 + 1] += degree;
        }
        
        
        // 행 방향 누적합 적용
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                deltaPrefix[i][j] += deltaPrefix[i][j - 1];
            }
        }
        
        // 열 방향 누적합 적용
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                deltaPrefix[j][i] += deltaPrefix[j - 1][i];
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) 
                if (board[i][j] + deltaPrefix[i][j] > 0) answer++;
        }
        
        return answer;
    }
}