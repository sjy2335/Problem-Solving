import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        System.out.println(bfs(board));
    }
    
    private int bfs(int[] board) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        dq.add(new int[]{1, 0});
        visited[1] = true;

        while (!dq.isEmpty()) {
            int[] node = dq.poll();
            int curr = node[0];
            int count = node[1];

            if (curr == 100) return count;

            if (board[curr] != 0) curr = board[curr];

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next <= 100 && !visited[next]) {
                    visited[next] = true;
                    dq.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}
