import java.io.*;
import java.util.*;

public class Main {

    private int N, M;
    private int[][] map;
    private int maxSecureArea;

    private final int[] dr = {-1,0,0,1};
    private final int[] dc = {0,-1,1,0};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxSecureArea = Integer.MIN_VALUE;

        constructAndEvaluate(0);

        bw.write(maxSecureArea + "\n");
        bw.close();

    }

    private void constructAndEvaluate(int wallCount) {
        if (wallCount == 3) {
            updateMaxSecureArea();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    constructAndEvaluate(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void updateMaxSecureArea() {
        int[][] clone = new int[N][M];
        for (int i = 0; i < N; i++) clone[i] = Arrays.copyOf(map[i], M);

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 2) {
                    deque.add(new int[]{i, j});
                }

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (clone[nr][nc] != 0) continue;
                clone[nr][nc] = 2;
                deque.add(new int[]{nr, nc});
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (clone[i][j] == 0) cnt++;


        maxSecureArea = Math.max(maxSecureArea, cnt);

    }
}
