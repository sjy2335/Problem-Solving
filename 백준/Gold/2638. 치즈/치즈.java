import java.io.*;
import java.util.*;

public class Main {

    private int N, M;
    private int[][] board;
    private final int[] dr = {-1, 0, 0, 1};
    private final int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (!isAllMelt()) {
            melt();
            time++;
        }

        bw.write(time + "\n");
        bw.close();
    }

    private boolean isAllMelt() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == 1) return false;

        return true;
    }

    private void melt() {
        boolean[][] visited = new boolean[N][M];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] > 0) {
                    board[nr][nc]++;
                    continue;
                }
                deque.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= 3)
                    board[i][j] = 0;
                else if (board[i][j] > 0) board[i][j] = 1;
            }
        }

    }
}
