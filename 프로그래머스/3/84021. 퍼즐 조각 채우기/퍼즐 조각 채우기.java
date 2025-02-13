import java.util.*;

class Solution {
    
    private static final int[] dr = {-1, 0, 0, 1};
    private static final int[] dc = {0, -1, 1, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        
        int[][][] boardCoords = findCoords(game_board, 0);
        int[][][] tableCoords = findCoords(table, 1);

		int[][][] boardMatrices = new int[boardCoords.length][][];
        for (int i = 0; i < boardMatrices.length; i++) {
            boardMatrices[i] = makeMatrix(boardCoords[i]);
        }
        
        int[][][] tableMatrices = new int[tableCoords.length][][];
        for (int i = 0; i < tableMatrices.length; i++) {
            tableMatrices[i] = makeMatrix(tableCoords[i]);
        }
        
        int answer = 0;

        for (int[][] tableMatrix : tableMatrices) {
            rotateLoop: for (int i = 0; i < 4; i++) {
                tableMatrix = rotate(tableMatrix);

                boardLoop: for (int j = 0; j < boardMatrices.length; j++) {
                    if (boardMatrices[j] == null) continue;

                    if (tableMatrix.length != boardMatrices[j].length || tableMatrix[0].length != boardMatrices[j][0].length)
                        continue;

                    int count = 0;
                    for (int r = 0; r < tableMatrix.length; r++) {
                        for (int c = 0; c < tableMatrix[0].length; c++) {
                            if (tableMatrix[r][c] != boardMatrices[j][r][c]) continue boardLoop;
                            if (tableMatrix[r][c] == 1) count++;
                        }
                    }

                    answer += count;
                    boardMatrices[j] = null;
                    break rotateLoop;
                }
            }
        }
        
       	return answer;
    }
    
    private int[][][] findCoords(int[][] board, int target) {
        int N = board.length;
        
        List<List<int[]>> coords = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        Deque<int[]> deq = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                if (visited[i][j] || board[i][j] != target) continue;
                
                List<int[]> crntCoords = new ArrayList<>();
                deq.add(new int[]{i, j});
                
                while (!deq.isEmpty()) {
                    
                    int[] crnt = deq.poll();
                    
                    int r = crnt[0];
                    int c = crnt[1];
                    
                    visited[r][c] = true;
                    crntCoords.add(new int[]{r, c});
                    
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (visited[nr][nc] || board[nr][nc] != target) continue;
                        
						deq.add(new int[]{nr, nc});
                    }
                }
                
                if (!crntCoords.isEmpty()) coords.add(crntCoords);
            }
        }
        
        return coords.stream()
            .map(list -> list.toArray(new int[0][]))
            .toArray(int[][][]::new);
    }
    
    private int[][] makeMatrix(int[][] coords) {
        int rowMin = Integer.MAX_VALUE;
        int colMin = Integer.MAX_VALUE;
        for (int[] coord: coords) {
            rowMin = Math.min(coord[0], rowMin);
            colMin = Math.min(coord[1], colMin);
        }
        
        for (int[] coord: coords) {
            coord[0] -= rowMin;
            coord[1] -= colMin;
        }
        
        int rowMax = Integer.MIN_VALUE;
        int colMax = Integer.MIN_VALUE;
        for (int[] coord: coords) {
            rowMax = Math.max(coord[0], rowMax);
            colMax = Math.max(coord[1], colMax);
        }

        int[][] arr = new int[rowMax + 1][colMax + 1];
        for (int[] coord: coords) {
            int r = coord[0];
            int c = coord[1];
            arr[r][c] = 1;
        }
        
        return arr;
    }
    
    private int[][] rotate(int[][] original) {
        
        int N = original.length;
        int M = original[0].length;
        
        int[][] rotated = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) rotated[j][i] = original[i][j];
        }
        
        for (int i = 0; i < M / 2; i++) {
            int[] temp = rotated[i];
            rotated[i] = rotated[M - 1 - i];
            rotated[M - 1 - i] = temp;
        }
        
        return rotated;
    }
}