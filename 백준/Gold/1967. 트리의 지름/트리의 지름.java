import java.io.*;
import java.util.*;

public class Main {

    int n;
    List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int[] target = findLongestFrom(0);
        int[] result = findLongestFrom(target[0]);

        System.out.println(result[1]);
    }

    private int[] findLongestFrom(int start) {

        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        dq.add(new int[]{start, 0});
        visited[start] = true;

        int targetNode = start;
        int maxLength = 0;

        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int curr = node[0];
            int length = node[1];

            if (maxLength < length) {
                maxLength = length;
                targetNode = curr;
            }

            for (int[] nextNode: adj.get(curr)) {
                int next = nextNode[0];
                int nextLength = nextNode[1];
                if (visited[next]) continue;
                visited[next] = true;
                dq.add(new int[]{next, length + nextLength});
            }
        }

        return new int[]{targetNode, maxLength};
    }
}
