import java.io.*;
import java.util.*;

public class Main {

    private int N, K;
    private final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K <= N) { // 0까지 가야하는 경우는 여기서 해결
            System.out.println(N - K);
            return;
        }

        int[] times = new int[MAX + 1];
        Arrays.fill(times, MAX);

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l[1]));

        pq.add(new int[]{N, 0});
        times[N] = 0;

        // 중간에 찾았을 때 멈추면 안됨 (더 짧은 경우 나올 수도)
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curr = node[0];
            int time = node[1];

            int next = curr * 2;
            if (isValid(next) && times[next] > time) {
                times[next] = time;
                pq.add(new int[]{next, time});
            }

            time++;

            next = curr - 1;
            if (isValid(next) && times[next] > time) {
                times[next] = time;
                pq.add(new int[]{next, time});
            }

            next = curr + 1;
            if (isValid(next) && times[next] > time) {
                times[next] = time;
                pq.add(new int[]{next, time});
            }
        }

        System.out.println(times[K]);
    }

    private boolean isValid(int n) {
        return n > 0 && n <= MAX;
    }
}
