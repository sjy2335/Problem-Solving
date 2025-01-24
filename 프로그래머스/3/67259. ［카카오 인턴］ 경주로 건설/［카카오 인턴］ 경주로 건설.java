import java.util.*;

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
	private static final int ROW = 0;
	private static final int COL = 1;
    
    private static class Node {
        int row, col, dir, cost;
        
        public Node(int row, int col, int dir, int cost) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    private static int[] dirs = {ROW, COL, COL, ROW};

    private boolean isValid(int row, int col, int N) {
        if (row < 0 || col < 0 || row >= N || col >= N) return false;
        return true;
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        int answer = INF;
        
        int[][][] cost = new int[N][N][4];
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));

        while(!queue.isEmpty()) {
            Node crnt = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                
                int newRow = crnt.row + dr[i];
                int newCol = crnt.col + dc[i];
                int newDir = dirs[i];
                
                int newCost;
                if (crnt.dir == -1 || crnt.dir == newDir)
                    newCost = crnt.cost + 100;
                else newCost = crnt.cost + 600;
                    
                if (!isValid(newRow, newCol, N)) continue;
                
                if (board[newRow][newCol] == 1) continue;
                
                if (cost[newRow][newCol][i] != 0 && cost[newRow][newCol][i] <= newCost) continue;
                
                if (newRow == N-1 && newCol == N-1)
                    answer = Math.min(answer, newCost);
                
                cost[newRow][newCol][i] = newCost;
                queue.add(new Node(newRow, newCol, newDir, newCost));
            }

        }
        
		if (answer == INF) return -1;
        return answer;
    }
}