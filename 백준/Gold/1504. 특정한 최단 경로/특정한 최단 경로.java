import java.io.*;
import java.util.*;

public class Main {

    private final int INF = 300_000_000;
    private int N, M;
    private List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()) - 1;
        int v2 = Integer.parseInt(st.nextToken()) - 1;

        int d1 = bfs(0, v1);
        int d2 = bfs(0, v2);
        int d3 = bfs(v1, v2);
        int d4 = bfs(v1, N - 1);
        int d5 = bfs(v2, N - 1);

        if (d3 == INF) {
            System.out.println("-1\n");
            return;
        }

        if ((d1 == INF || d5 == INF) && (d2 == INF || d4 == INF)) {
            System.out.println("-1\n");
            return;
        }

        int result = Math.min(d1 + d5, d2 + d4) + d3;
        System.out.println(result + "\n");
    }

    private int bfs(int from, int to) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, INF);

        pq.add(new int[]{from, 0});
        dist[from] = 0;

        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int curr = currNode[0];
            int currDist = currNode[1];

            if (visited[curr]) continue;
            visited[curr] = true;

            if (curr == to) return currDist;

            for (int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int nextDist = currDist + nextNode[1];

                dist[next] = Math.min(dist[next], nextDist);
                pq.add(new int[]{next, dist[next]});
            }
        }

        return INF;

    }
}
