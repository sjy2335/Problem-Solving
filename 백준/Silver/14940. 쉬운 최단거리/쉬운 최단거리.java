import java.io.*;
import java.util.*;

public class Main {

    private final int[] dr = {-1, 0, 0, 1};
    private final int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) dist[i][j] = 0;
                if (map[i][j] == 2) start = new int[] {i, j};
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();

        dq.add(start);
        dist[start[0]][start[1]] = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0], c = curr[1];
            int prev = dist[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (dist[nr][nc] != -1) continue;
                if (dist[nr][nc] == 0) continue;

                dist[nr][nc] = prev + 1;
                dq.add(new int[] {nr, nc});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();
    }
}
