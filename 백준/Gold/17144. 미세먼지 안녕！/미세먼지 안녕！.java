import java.io.*;
import java.util.*;

public class Main {

    private int R, C, T;
    private int[][] map;

    private int[] dr = {-1,0,0,1};
    private int[] dc = {0,-1,1,0};

    private int pr1 = -1;
    private int pr2 = -1;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (pr1 == -1) pr1 = i;
                    else pr2 = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            clean();
        }

        bw.write(count() + "\n");
        bw.close();
    }

    private void spread() {
        int[][] clone = new int[R][];
        for (int i = 0; i < R; i++)
            clone[i] = Arrays.copyOf(map[i], C);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                int curr = map[i][j];
                if (curr <= 0)
                    continue; // 미세먼지가 없거나 공기청정기가 있으면 건너뜀

                int share = curr / 5;
                int spreadCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                        continue;
                    if (map[nr][nc] == -1)
                        continue;
                    spreadCount++;
                    clone[nr][nc] += share;
                }

                clone[i][j] -= share * spreadCount;
            }
        }

        map = clone;
    }

    private void clean() {
        // 위쪽 공기청정기 (반시계 방향)
        for (int r = pr1 - 1; r > 0; r--) map[r][0] = map[r - 1][0];
        for (int c = 0; c < C - 1; c++) map[0][c] = map[0][c + 1];
        for (int r = 0; r < pr1; r++) map[r][C - 1] = map[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[pr1][c] = map[pr1][c - 1];
        map[pr1][1] = 0; // 공기청정기에서 처음 나온 공기

        // 아래쪽 공기청정기 (시계 방향)
        for (int r = pr2 + 1; r < R - 1; r++) map[r][0] = map[r + 1][0];
        for (int c = 0; c < C - 1; c++) map[R - 1][c] = map[R - 1][c + 1];
        for (int r = R - 1; r > pr2; r--) map[r][C - 1] = map[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--) map[pr2][c] = map[pr2][c - 1];
        map[pr2][1] = 0; // 공기청정기에서 처음 나온 공기
    }

    private int count() {
        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                sum += map[i][j] == -1 ? 0 : map[i][j];

        return sum;
    }
}
