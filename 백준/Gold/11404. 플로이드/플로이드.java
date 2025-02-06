import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(cache[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) cache[i][i] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cache[a - 1][b - 1] = Math.min(cache[a - 1][b - 1], c);
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (cache[i][k] == Integer.MAX_VALUE || cache[k][j] == Integer.MAX_VALUE) continue;
                    cache[i][j] = Math.min(cache[i][j], cache[i][k] + cache[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cache[i][j] == Integer.MAX_VALUE) cache[i][j] = 0;
                sb.append(cache[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
