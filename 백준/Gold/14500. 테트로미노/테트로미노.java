import java.util.*;
import java.io.*;

public class Main {

    private int N, M;
    private int[][] board;
    private boolean[][] visited;
    private int answer = 0;
    private final int[] dx = {-1, 0, 0, 1};
    private final int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                backtrack(i, j, 1, board[i][j]);
                visited[i][j] = false;

                checkTShape(i, j);
            }
        }
        System.out.println(answer);
    }

    private void backtrack(int x, int y, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            backtrack(nx, ny, count + 1, sum + board[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private void checkTShape(int x, int y) {
        int[][] tShapes = {
            {0, -1, 0, 1, -1, 0},
            {-1, 0, 1, 0, 0, 1},
            {-1, 0, 0, -1, 1, 0},
            {0, -1, 0, 1, 1, 0}
        };

        for (int[] t : tShapes) {
            int nx1 = x + t[0], ny1 = y + t[1];
            int nx2 = x + t[2], ny2 = y + t[3];
            int nx3 = x + t[4], ny3 = y + t[5];

            if (nx1 < 0 || ny1 < 0 || nx1 >= N || ny1 >= M) continue;
            if (nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M) continue;
            if (nx3 < 0 || ny3 < 0 || nx3 >= N || ny3 >= M) continue;

            int sum = board[x][y] + board[nx1][ny1] + board[nx2][ny2] + board[nx3][ny3];
            answer = Math.max(answer, sum);
        }
    }
}
