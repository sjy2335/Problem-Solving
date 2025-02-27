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
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

        List<List<int[]>> adj1 = new ArrayList<>();
        List<List<int[]>> adj2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            adj1.get(u).add(new int[]{v, w});
            adj2.get(v).add(new int[]{u, w});
        }

        int[] res1 = dijkstra(adj1, X, N);
        int[] res2 = dijkstra(adj2, X, N);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, res1[i] + res2[i]);
        }

        bw.write(answer + "\n");
        bw.close();
    }

    private int[] dijkstra(List<List<int[]>> adj, int from, int N) {
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));

        distance[from] = 0;
        pq.add(new int[]{from, 0});

        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int curr = currNode[0];
            int currDist = currNode[1];

            if (visited[curr]) continue;
            visited[curr] = true;

            for (int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int nextDist = currDist + nextNode[1];
                distance[next] = Math.min(distance[next], nextDist);
                pq.add(new int[]{next, distance[next]});
            }
        }

        return distance;
    }
}
