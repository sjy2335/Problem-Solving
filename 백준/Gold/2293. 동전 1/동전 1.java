import java.io.*;
import java.util.*;

public class Main {

    private final int INF = 100000;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] prices = new int[N];
        for (int i = 0; i < N; i++)
            prices[i] = Integer.parseInt(br.readLine());

        int[] cache = new int[K + 1];
        cache[0] = 1;

        for (int price: prices)
            for (int i = price; i <= K; i ++)
                cache[i] += cache[i - price];

        bw.write(cache[K] + "\n");
        bw.close();

    }
}
