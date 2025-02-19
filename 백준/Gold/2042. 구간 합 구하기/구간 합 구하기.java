import java.io.*;
import java.util.*;

public class Main {

    int N, M, K, N2;
    long[] segTree;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        N2 = 1;
        while (N2 < N) N2 *= 2;

        segTree = new long[N2 * 2];
        for (int i = N2; i < N2 + N; i++) segTree[i] = Long.parseLong(br.readLine());
        for (int i = N2 - 1; i > 0; i--) segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1)
                update(b, c);

            if (a == 2)
                sb.append(sum(b, (int) c, 1, 1, N2)).append("\n");
        }

        System.out.println(sb);
    }

    private void update(int b, long c) {
        int idx = b + N2 - 1;
        long diff = c - segTree[idx];

        for (int i = idx; i >= 1; i /= 2) {
            segTree[i] += diff;
        }
    }

    private long sum(int b, int c, int node, int nL, int nR) {
        if (nR < b || c < nL) return 0L;
        if (b <= nL && nR <= c) return segTree[node];

        int mid = (nL + nR) / 2;

        return sum(b, c, node * 2, nL, mid)
            + sum(b, c, node * 2 + 1, mid + 1, nR);
    }
}
