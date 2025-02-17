import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] cache = new int[N + 1];
            cache[1] = 1;
            if (N > 1) cache[2] = 2;
            if (N > 2) cache[3] = 4;

            for (int i = 4; i <= N; i++)
                cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];

            sb.append(cache[N]).append("\n");
        }

        System.out.println(sb);
    }
}
