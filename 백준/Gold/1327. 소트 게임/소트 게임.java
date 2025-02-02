import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    class Node {
        String value;
        int count;

        Node(String v, int c) {
            this.value = v;
            this.count = c;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sb.append(arr[i]);
        }
        String first = sb.toString();
        sb.setLength(0);

        Arrays.sort(arr);
        for (int n: arr) sb.append(n);
        String target = sb.toString();
        sb.setLength(0);

        ArrayDeque<Node> dq = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        dq.add(new Node(first, 0));
        set.add(first);

        while (!dq.isEmpty()) {
            Node crr = dq.poll();
            String value = crr.value;
            int count = crr.count;

            if (value.equals(target)) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i <= N - K; i++) {
                String s1 = value.substring(0, i);
                String s2 = sb.append(value, i, i + K).reverse().toString();
                String s3 = value.substring(i + K);
                sb.setLength(0);
                String result = sb.append(s1).append(s2).append(s3).toString();
                sb.setLength(0);
                if (set.contains(result)) continue;
                set.add(result);
                dq.add(new Node(result, count + 1));
            }
        }
        System.out.println(-1);
    }
}
