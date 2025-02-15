import java.io.*;
import java.util.*;

public class Main {

    int N;
    Long[][] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new Long[N + 1][2];

        cache[1][0] = 0L;
        cache[1][1] = 1L;

        System.out.println(dp(N, 0) + dp(N, 1));
    }

    private long dp(int n, int i) {
        if (cache[n][i] != null) return cache[n][i];

        if (i == 0) return cache[n][0] = dp(n - 1, 0) + dp(n - 1, 1);
        else return cache[n][1] = dp(n - 1, 0);
    }
}
