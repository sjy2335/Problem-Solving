import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int count = 0;
            int[] adj = new int[N];
            boolean[] visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[j] = Integer.parseInt(st.nextToken()) - 1; // 0부터 시작으로 바꿈
            }

            for (int j = 0; j < N; j++) {
                if (visited[j]) continue;
                dfs(j, adj, visited);
                count++;
            }
            System.out.println(count);
        }
    }

    private void dfs(int i, int[] adj, boolean[] visited) {
        visited[i] = true;
        if (!visited[adj[i]]) dfs(adj[i], adj, visited);
    }
}
