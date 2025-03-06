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
        int[][] clone = new int[R][];
        for (int i = 0; i < R; i++)
            clone[i] = Arrays.copyOf(map[i], C);

        // 반시계 방향
        dr = new int[]{0, -1, 0, 1};
        dc = new int[]{1, 0, -1, 0};

        int r = pr1;
        int c = 1;
        clone[r][c] = 0; // 청정기에서 처음 나온 공기

        for (int i = 0; i < 4; i++) {
            while (true) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) break;
                if (map[nr][nc] == -1) break;
                clone[nr][nc] = map[r][c];
                r = nr;
                c = nc;
            }
        }

        // 시계 방향
        dr = new int[]{0, 1, 0, -1};
        dc = new int[]{1, 0, -1, 0};

        r = pr2;
        c = 1;
        clone[r][c] = 0; // 청정기에서 처음 나온 공기

        for (int i = 0; i < 4; i++) {
            while (true) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) break;
                if (map[nr][nc] == -1) break;
                clone[nr][nc] = map[r][c];
                r = nr;
                c = nc;
            }
        }

        map = clone;
    }

    private int count() {
        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                sum += map[i][j] == -1 ? 0 : map[i][j];

        return sum;
    }
}
