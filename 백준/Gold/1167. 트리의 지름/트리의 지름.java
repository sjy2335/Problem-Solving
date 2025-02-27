import java.io.*;
import java.util.*;

public class Main {

    private int N;
    private List<List<int[]>> adj;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 입력 그대로 인접 리스트 생성
        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            List<int[]> curr = adj.get(u);

            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;  // 종료 신호는 -1

                int w = Integer.parseInt(st.nextToken());
                curr.add(new int[]{v - 1, w});
            }
        }

        // 시작정점 주어지면 {가장 먼 정점, 거리} 반환
        long[] result1 = longestFrom(0);
        long[] result2 = longestFrom((int) result1[0]);

        bw.write(result2[1] + "\n");
        bw.flush();
        bw.close();
    }

    private long[] longestFrom(int start) {
        Deque<long[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        deque.add(new long[]{(long) start, 0L});
        visited[start] = true;

        long[] result = new long[2];

        while (!deque.isEmpty()) {
            long[] currNode = deque.poll();
            long curr = currNode[0];
            long currDist = currNode[1];

            if (result[1] < currDist) {
                result[0] = curr;
                result[1] = currDist;
            }

            for (int[] nextNode: adj.get((int) curr)) {
                long next = nextNode[0];
                long nextDist = currDist + (long) nextNode[1];

                if (visited[(int) next]) continue;
                visited[(int) next] = true;
                deque.add(new long[]{next, nextDist});
            }
        }

        return result;

    }
}
