import java.io.*;
import java.util.*;

public class Main {

    private int[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cache = new int[N + 1];
        Arrays.fill(cache, -1);

        System.out.println(countP(N));
    }

    private int countP(int n) {

        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 15746;
        }

        return cache[n];
    }
}
