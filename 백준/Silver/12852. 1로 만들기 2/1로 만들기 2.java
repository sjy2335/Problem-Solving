import java.io.*;

public class Main {

    private int N;
    private Integer[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        cache = new Integer[N + 1];
        cache[1] = 0;

        int res = f(N);
        bw.write(res + "\n");

        int[] resArr = new int[res + 1];
        int j = 0;
        for (int i = N; i > 1;) {
            resArr[j] = i;
            j++;
            if (i % 3 == 0 && cache[i / 3] + 1 == cache[i]) {
                i /= 3;
            }
            else if (i % 2 == 0 && cache[i / 2] + 1 == cache[i]) {
                i /= 2;
            }
            else {
                i--;
            }
        }
        resArr[res] = 1;

        for (int n: resArr) bw.write(n + " ");

        bw.close();
    }

    private int f(int n) {
        if (n == 1) return 0;
        if (cache[n] != null) return cache[n];

        int res1 = Integer.MAX_VALUE;
        int res2 = Integer.MAX_VALUE;
        if (n % 3 == 0)
            res1 = f(n / 3) + 1;
        if (n % 2 == 0)
            res2 = f(n / 2) + 1;
        int res3 = f(n - 1) + 1;

        return cache[n] = Math.min(res1, Math.min(res2, res3));
    }
}
