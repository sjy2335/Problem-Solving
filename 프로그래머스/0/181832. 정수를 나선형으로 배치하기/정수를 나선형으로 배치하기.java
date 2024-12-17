class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0, direction = 0;
        
        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];
            
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || answer[nextX][nextY] != 0) {
                direction = (direction + 1) % 4;
                nextX = x + dx[direction];
                nextY = y + dy[direction];
            }
            x = nextX;
            y = nextY;
        }
        
        return answer;
    }
}