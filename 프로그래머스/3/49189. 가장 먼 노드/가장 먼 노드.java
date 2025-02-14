import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            adj[e[0] - 1].add(e[1] - 1);
            adj[e[1] - 1].add(e[0] - 1);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int crnt = queue.poll();

            for (int next : adj[crnt]) {
                if (dist[next] == -1) {
                    dist[next] = dist[crnt] + 1;
                    queue.add(next);
                }
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();
        return (int) Arrays.stream(dist).filter(i -> i == max).count();
    }
}