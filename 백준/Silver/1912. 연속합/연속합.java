import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] prefixArray = new int[N + 1];

        int min = 0;
        int result = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixArray[i] = prefixArray[i - 1] + Integer.parseInt(st.nextToken());
            result = Math.max(result, prefixArray[i] - min);
            min = Math.min(min, prefixArray[i]);
        }

        bw.write(result + "\n");
        bw.close();
    }
}
