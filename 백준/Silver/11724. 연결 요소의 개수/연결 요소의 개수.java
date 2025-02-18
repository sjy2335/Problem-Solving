import java.io.*;
import java.util.*;

public class Main {
    
    private List<Integer>[] adj;
    private boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        adj = new List[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i);
            count++;
        }
        
        System.out.println(count);
    }
    
    private void dfs(int i) {
        for (int a: adj[i]) {
            if (visited[a]) continue;
            visited[a] = true;
            dfs(a);
        }
    }
}