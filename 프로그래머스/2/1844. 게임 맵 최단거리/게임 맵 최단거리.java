import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public static int r, c;
    
    public static boolean isAvailable(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= r || nc >= c) return false;
        return true;
    }
    
    public int solution(int[][] map) {
        
        r = map.length;
        c = map[0].length;
        
        int[][] dist = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist[i], 0);
        }
        
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int crntR = point[0];
            int crntC = point[1];
            int crntDist = dist[crntR][crntC];
            
            for (int i = 0; i < 4; i++) {
                int newR = crntR + dr[i];
                int newC = crntC + dc[i];
                if (isAvailable(newR, newC) && map[newR][newC] == 1) {
                    if (dist[newR][newC] > crntDist + 1 || dist[newR][newC] == 0) {
	                    queue.add(new int[]{newR, newC});
                        dist[newR][newC] = crntDist + 1;
                    }
                }
            }
        }
        
        if (dist[r-1][c-1] == 0) return -1;
        
        return dist[r-1][c-1];
    }
}