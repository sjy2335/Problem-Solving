import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        Set<Integer> visited = new HashSet<>();
        Deque<int[]> dq = new ArrayDeque<>();
        
        dq.add(new int[]{A, 0});
        visited.add(A);
        
        while (!dq.isEmpty()) {
            int[] currNode = dq.poll();
            int curr = currNode[0];
            int currCount = currNode[1];
            
            if (curr == B) {
                bw.write(Integer.toString(currCount + 1));
                bw.write("\n");
                bw.close();
                return;
            }
            
            if (curr <= B / 2) {
                int next = curr * 2;
                if (!visited.contains(next)) {
                    visited.add(next);
                    dq.add(new int[]{next, currCount + 1});
                }
            }
            
            if (curr <= (B - 1) / 10) {
                int next = curr * 10 + 1;
                if (!visited.contains(next)) {
                    visited.add(next);
                    dq.add(new int[]{next, currCount + 1});
                }         
            }
        }
        
        bw.write("-1\n");
        bw.close();
        
    }
}