import java.io.*;
import java.util.*;

public class Main {

    private int n;
    private int[][] scores;
    private Integer[][] caches;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            n = Integer.parseInt(br.readLine());
            scores = new int[2][n];
            caches = new Integer[3][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    scores[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append(dp(0, 2)).append("\n");

        }

        System.out.println(sb);
    }

    private int dp(int col, int status) {
        if (col == n) return 0;
        if (caches[status][col] != null) return caches[status][col];

        int result = dp(col + 1, 2);
        if (status != 0) result = Math.max(result, dp(col + 1, 0) + scores[0][col]);
        if (status != 1) result = Math.max(result, dp(col + 1, 1) + scores[1][col]);

        return caches[status][col] = result;
    }
}
