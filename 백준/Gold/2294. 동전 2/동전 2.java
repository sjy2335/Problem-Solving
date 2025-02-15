import java.io.*;
import java.util.*;

public class Main {

    private final int IMPOSSIBLE = 100_000;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> coinSet = new HashSet<>();
        int[] cache = new int[K + 1];
        Arrays.fill(cache, IMPOSSIBLE);

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > K) continue;
            coinSet.add(value);
            cache[value] = 1;
        }

        List<Integer> coins = new ArrayList<>(coinSet);
        coins.sort(Collections.reverseOrder());

        for (int coin: coins) {
            for (int value = coin; value <= K; value++) {
                cache[value] = Math.min(cache[value], cache[value - coin] + 1);
            }
        }

        if (cache[K] == IMPOSSIBLE) System.out.println(-1);
        else System.out.println(cache[K]);

    }
}
