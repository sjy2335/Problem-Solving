import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] caches = new int[N + 1][10];
        Arrays.fill(caches[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 9; k >= j; k--) {
                    caches[i][k] = (caches[i][k] + caches[i - 1][j]) % 10_007;
                }

            }
        }

        System.out.println(Arrays.stream(caches[N])
                                 .reduce(0, Integer::sum) % 10_007);

    }
}
