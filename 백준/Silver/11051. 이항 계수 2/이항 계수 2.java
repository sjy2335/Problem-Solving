import java.io.*;
import java.util.*;

public class Main {

    private int N;
    private int K;
    private int[][] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        K = Math.max(N - K, K);

        cache = new int[N + 1][K + 1];

        System.out.println(f(N, K));
    }

    private int f(int n, int k) {
        if (n == k || k == 0) return 1;
        if (cache[n][k] != 0) return cache[n][k];

        return cache[n][k] = (f(n - 1, k) + f(n - 1, k - 1)) % 10_007;
    }
}
