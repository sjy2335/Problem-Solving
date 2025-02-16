import java.io.*;
import java.util.*;

public class Main {

    private int N, K;
    private int[] weights, values;
    private Integer[][] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        values = new int[N];
        cache = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(f(0, K));
    }

    private int f(int n, int k) {
        if (n == N) return 0;
        if (cache[n][k] != null) return cache[n][k];

        int w = weights[n];
        int v = values[n];

        int result = f(n + 1, k);
        if (k >= w)
            result = Math.max(result, f(n + 1, k - w) + v);

        return cache[n][k] = result;
    }
}
