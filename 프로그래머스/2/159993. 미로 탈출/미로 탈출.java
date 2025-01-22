import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
	private static char[][] map;
    private static int[] start;
    private static int[] lever;
    private static int[] end;
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    
    private int bfs(int[] s, int[] e, int startTime) {
		
        Deque<int[]> queue = new ArrayDeque<>();
        
        int[][] time = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(time[i], -1);
        }
        
        queue.add(s);
        time[s[0]][s[1]] = startTime;
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int crntR = point[0], crntC = point[1];
            int crntT = time[crntR][crntC];
            
            for (int i = 0; i < 4; i++) {
                int newR = crntR + dr[i], newC = crntC + dc[i];
                
                if (newR < 0 || newC < 0 || newR >= map.length || newC >= map[0].length) continue;
                if (map[newR][newC] == 'X') continue;
             	if (time[newR][newC] != -1) continue;
                
                time[newR][newC] = crntT + 1;
                queue.add(new int[]{newR, newC});
            }
        }
        
        return time[e[0]][e[1]];
    }
    
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                map[i][j] = c;
                if (c == 'S') start = new int[] {i, j};
                else if (c == 'L') lever = new int[] {i, j};
                else if (c == 'E') end = new int[] {i, j};
            }
        }
        
		int leverTime = bfs(start, lever, 0);        
        if (leverTime == -1) return -1;
        return bfs(lever, end, leverTime);
    }
}