import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N][N];

        int INF = 10_000;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dist[i][j] = i == j ? 0 : INF;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int min = INF;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = Arrays.stream(dist[i]).sum();
            min = Math.min(min, res[i]);
        }

        for (int i = 0; i < N; i++) {
            if (min == res[i]) {
                System.out.println(i + 1);
                break;
            }
        }

    }
}
