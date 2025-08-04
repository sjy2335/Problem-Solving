import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            long[] heights = new long[n];
            for (int i = 0; i < n; i++)
                heights[i] = Integer.parseInt(st.nextToken());

            Deque<long[]> stack = new ArrayDeque<>();
            stack.push(new long[]{heights[0], 0});
            long answer = 0;

            for (int i = 0; i < n; i++) {
                int start = i;

                while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                    long[] popped = stack.pop();
                    answer = Math.max(answer, popped[0] * (i - popped[1]));
                    start = (int)popped[1];
                }

                stack.push(new long[]{heights[i], start});
            }

            while (!stack.isEmpty()) {
                long[] popped = stack.pop();
                answer = Math.max(answer, popped[0] * (n - popped[1]));
            }

            bw.write(answer + "\n");
        }

        bw.close();
    }
}
