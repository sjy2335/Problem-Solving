import java.io.*;
import java.util.*;

public class Main {

    private int N, R, Q;
    private List<List<Integer>> adj;
    private Integer[] parent;
    private int[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        parent = new Integer[N];
        cache = new int[N];
        parent[R] = -1;
        dfs(R); // tree 구성


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int subRoot = Integer.parseInt(br.readLine()) - 1;
            sb.append(cache[subRoot]).append("\n");
        }

        System.out.println(sb);
    }

    private int dfs(int curr) {

        int count = 1;
        for (int next: adj.get(curr)) {
            if (parent[next] != null) continue;
            parent[next] = curr;
            count += dfs(next);
        }

        return cache[curr] = count;
    }
}
