import java.io.*;
import java.util.*;

public class Main {

    private class Bus {
        int dest, cost;

        Bus(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private int N, M, A, B;
    private List<List<Bus>> adj;
    private boolean[] visited;
    private int[] cost;


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);

        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u - 1).add(new Bus(v - 1, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) - 1;
        B = Integer.parseInt(st.nextToken()) - 1;

        Queue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        pq.add(new Bus(A, 0));
        cost[A] = 0;

        while (!pq.isEmpty()) {
            Bus curr = pq.poll();

            if (curr.dest == B) {
                System.out.println(curr.cost + "\n");
                return;
            }

            if (visited[curr.dest]) continue;
            visited[curr.dest] = true;

            for (Bus next: adj.get(curr.dest)) {
                if (cost[next.dest] > curr.cost + next.cost) {
                    cost[next.dest] = curr.cost + next.cost;
                    pq.add(new Bus(next.dest, cost[next.dest]));
                }
            }
        }
    }
}
