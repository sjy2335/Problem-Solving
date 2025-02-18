import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Long> minHeap = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            long x = Long.parseLong(br.readLine());
            if (x == 0L) sb.append(minHeap.isEmpty() ? 0 : minHeap.poll()).append("\n");
            else minHeap.add(x);
        }
        
        System.out.println(sb);
    }
}