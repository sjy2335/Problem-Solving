import java.io.*;
import java.util.*;

public class Main {

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

        int count = 0;
        for (int i = N - 1; i >= 0 && K > 0; i--) {
            int share = K / prices[i];
            K -= prices[i] * share;
            count += share;
        }

        bw.write(count + "\n");
        bw.close();


    }
}
