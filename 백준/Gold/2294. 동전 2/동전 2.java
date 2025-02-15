import java.io.*;
import java.util.*;

public class Main {

    private final int IMPOSSIBLE = 100_000;

    private int N;
    private int K;

    private int[] coins;
    private Integer[][] caches;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());

        caches = new Integer[N][K + 1];

        int result = dp(0, K);

        if (result == IMPOSSIBLE) System.out.println(-1);
        else System.out.println(result);
    }

    // [n, N) 범위 동전들만 사용해서 k원을 만드는 데 필요한 동전의 최솟값
    private int dp(int n, int k) {
        if (n == N && k == 0) return 0;
        if (n == N && k > 0) return IMPOSSIBLE;
        if (caches[n][k] != null) return caches[n][k];

        if (k < coins[n]) return caches[n][k] = dp(n + 1, k);

        return caches[n][k]
            = Math.min(dp(n + 1, k), dp(n, k - coins[n]) + 1);
    }
}
