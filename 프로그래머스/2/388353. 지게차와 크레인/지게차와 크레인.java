import java.util.*;

class Solution {
    
    private char[][] containers;
            
	private final int[] dr = {-1, 0, 0, 1};
    private final int[] dc = {0, -1, 1, 0};
    
    public int solution(String[] storage, String[] requests) {
        
        int n = storage.length + 2;
        int m = storage[0].length() + 2;
        
        containers = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) containers[i][j] = 'x';
                else containers[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for (String request: requests) {
            
            char target = request.charAt(0);

            if (request.length() == 1) {
                List<int[]> targets = new ArrayList<>();
                boolean[][] visited = new boolean[n][m];
                Deque<int[]> dq = new ArrayDeque<>();
                dq.add(new int[]{0, 0});
                visited[0][0] = true;
                
                while (!dq.isEmpty()) {
                    
                    int[] crnt = dq.poll();
                    int r = crnt[0], c = crnt[1];
                    
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i], nc = c + dc[i];
                        if (nr < 0 || nc < 0 || nr == n || nc == m) continue;
                        if (visited[nr][nc]) continue;
                        if (containers[nr][nc] == 'x') {
                            dq.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                        if (containers[nr][nc] == target) {
                            targets.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
                
                for (int[] t: targets) {
                    int r = t[0], c = t[1];
                    containers[r][c] = 'x';
                }
            }
            
            else {
                for (int i = 0; i < containers.length; i++)
                    for (int j = 0; j < containers[0].length; j++)
                        if (containers[i][j] == target)
                            containers[i][j] = 'x';
            }
        }
        
        int answer = 0;
        for (char[] cc: containers) {
            for (char c: cc) if (c != 'x') answer++;
        }
        
        return answer;
    }
    
}