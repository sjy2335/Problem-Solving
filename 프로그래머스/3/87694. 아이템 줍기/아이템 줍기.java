import java.util.*;

class Solution {
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 한 칸 띄어져 있어도 붙어 있게 표시됨
        // 보드 2배로 넓혀서 체크.. 더 나은 방법?
        boolean[][] board = new boolean[102][102];
        boolean[][] visited = new boolean[102][102];
        
        for (int[] rect : rectangles) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                board[i][y1] = true;
                board[i][y2] = true;
            }
            for (int i = y1; i <= y2; i++) {
                board[x1][i] = true;
                board[x2][i] = true;
            }
        }

        for (int[] rect : rectangles) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    board[i][j] = false;
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            if (cx == itemX * 2 && cy == itemY * 2) return dist / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if (!board[nx][ny] || visited[nx][ny]) continue;

                queue.add(new int[]{nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return answer;
    }
}