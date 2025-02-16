import java.io.*;
import java.util.*;

public class Main {

    private final long DIVIDER = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) dp[1][i] = 1L;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % DIVIDER;
            }
        }

        long result = Arrays.stream(dp[N]).reduce(0L, (acc, crnt) -> acc + crnt) % DIVIDER;

        System.out.println(result);
    }
}
