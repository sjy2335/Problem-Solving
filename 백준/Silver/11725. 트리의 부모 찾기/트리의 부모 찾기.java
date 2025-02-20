import java.io.*;
import java.util.*;

public class Main {

    private int[] parent;
    private List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        parent[1] = 1;
        f(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.close();
    }

    private void f(int i) {
        for (int j: adj.get(i)) {
            if (parent[j] != 0) continue;
            parent[j] = i;
            f(j);
        }
    }
}
