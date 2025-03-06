import java.io.*;
import java.util.*;

public class Main {

    private int N, L;
    private long I;
    private long[][] cache;
    private char[] result;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N자리 이진수
        L = Integer.parseInt(st.nextToken()); // L개의 1만 사용
        I = Long.parseLong(st.nextToken()); // I번째 이진수
        cache = new long[N + 1][L + 1]; // n번째까지 채웠을 때, l개의 1을 사용할 수 있을 때, 이진수의 개수
        result = new char[N];

        skip(N, L, I - 1L);

        for (int i = 0; i < N; i++) bw.write(result[i]);
        bw.write("\n");
        bw.close();
    }

    private long countBinary(int n, int l) {
        if (cache[n][l] != 0) return cache[n][l];
        if (n == 0 || l == 0) return cache[n][l] = 1L;

        long res = countBinary(n - 1, l);

        res += countBinary(n - 1, l - 1); // 사용할 수 있는 l이 남아있으면

        return cache[n][l] = res;
    }

    private void skip(int n, int l, long i) {
        if (n == 0) return;
        if (l == 0) {
            for (int j = 0; j < n; j++) result[N - n + j] = '0';
            return;
        }
        long count = countBinary(n - 1, l);
        if (i < count) {
            result[N - n] = '0';
            skip(n - 1, l, i);
        } else {
            result[N - n] = '1';
            skip(n - 1, l - 1, i - count);
        }
    }
}
