import java.io.*;
import java.util.*;

public class Main {

    private int N;
    private List<Integer>[] adj, children;
    private boolean[] visited;
    private Integer[][] cache;

    private final int TRUE = 1;
    private final int FALSE = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new List[N];
        children = new List[N];
        visited = new boolean[N];
        cache = new Integer[N][2];
        for (int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        makeTree(0);

        System.out.println(getMinimalEAs(0, TRUE));
    }

    private void makeTree(int curr) {
        visited[curr] = true;
        for (int next: adj[curr]) {
            if (!visited[next]) {
                children[curr].add(next);
                makeTree(next);
            }
        }
    }

    private int getMinimalEAs(int curr, int parentEAFlag) {

        if (cache[curr][parentEAFlag] != null) return cache[curr][parentEAFlag];

        int pick = 1;
        for (int next: children[curr])
            pick += getMinimalEAs(next, TRUE);

        if (parentEAFlag == FALSE) return cache[curr][parentEAFlag] = pick;

        int unpick = 0;
        for (int next: children[curr])
            unpick += getMinimalEAs(next, FALSE);

        return cache[curr][parentEAFlag] = Math.min(pick, unpick);
    }

}
