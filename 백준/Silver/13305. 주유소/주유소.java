import java.util.*;
import java.io.*;

public class Main {

    int N;
    long[] roads;
    long[] prices;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        roads = new long[N - 1];
        prices = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long totalPrice = 0;
        for (int i = 0; i < N - 1;) {
            // 다음 주유소가 현재보다 싸다면 최소한으로.
            if (prices[i] > prices[i + 1]) {
                totalPrice += prices[i] * roads[i];
                i++;
            // 다음 주유소가 현재보다 비싸면 다음 거리까지 포함해서.
            // -> 더 싼 곳이 나올때까지.
            } else {
                int j = i;
                long dist = 0;
                while (j < N - 1) {
                    dist += roads[j];
                    if (prices[i] > prices[++j]) break;
                }
                totalPrice += prices[i] * dist;
                i = j;
            }
        }

        System.out.println(totalPrice);
    }
}
