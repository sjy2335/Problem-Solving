import java.io.*;
import java.util.*;

public class Main {
    class Node {
        int value;
        int count;
        int index;

        Node(int value, int count, int index) {
            this.value = value;
            this.count = count;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstAppearance = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
            firstAppearance.putIfAbsent(number, i);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count)
                return Integer.compare(b.count, a.count);
            return Integer.compare(a.index, b.index);
        });

        frequency.forEach((key, count) -> pq.add(new Node(key, count, firstAppearance.get(key))));

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node crnt = pq.poll();
            while (crnt.count-- > 0) {
                sb.append(crnt.value).append(" ");
            }
        }

        System.out.println(sb);
    }
}