import java.io.*;
import java.util.*;

public class Main {

    private int N, max, min;
    private int[] arr;
    private int[] ops = new int[4];

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        backtrack(1, arr[0]);

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.close();
    }

    private void backtrack(int idx, int val) {
        if (idx == N) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        if (ops[0] > 0) {
            ops[0] -= 1;
            backtrack(idx + 1, val + arr[idx]);
            ops[0] += 1;
        }
        if (ops[1] > 0) {
            ops[1] -= 1;
            backtrack(idx + 1, val - arr[idx]);
            ops[1] += 1;
        }
        if (ops[2] > 0) {
            ops[2] -= 1;
            backtrack(idx + 1, val * arr[idx]);
            ops[2] += 1;
        }
        if (ops[3] > 0) {
            ops[3] -= 1;
            backtrack(idx + 1, val / arr[idx]);
            ops[3] += 1;
        }
    }
}
