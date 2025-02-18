import java.io.*;
import java.util.*;

public class Main {
    
    private final char[] DSLR = {'D', 'S', 'L', 'R'};
    
    private class Node {
        int value;
        String commands;
        
        Node(int v, String c) {
            this.value = v;
            this.commands = c;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[10001];
            Deque<Node> dq = new ArrayDeque<>();
            
            visited[start] = true;
            dq.add(new Node(start, ""));
            
            while (!dq.isEmpty()) {
                Node node = dq.poll();
                int currV = node.value;
                String currC = node.commands;
                
                if (currV == target) {
                    bw.write(currC + "\n");
                    break;
                }
                
                int[] values = new int[4];
                values[0] = D(currV);
                values[1] = S(currV);
                values[2] = L(currV);
                values[3] = R(currV);
                
                for (int i = 0; i < 4; i++) {
                    if (visited[values[i]]) continue;
                    visited[values[i]] = true;
                    dq.add(new Node(values[i], currC + DSLR[i]));
                }
            }
        }
        
        bw.flush();
        bw.close();
    }
    
    
    private int D(int n) {
        return (2 * n) % 10000;
    }
    
    private int S(int n) {
        if (n == 0) return 9999;
        return n - 1;
    }
    
    private int L(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        while (sb.length() < 4) sb.insert(0, "0");
        
        sb.append(sb.charAt(0));
        sb.deleteCharAt(0);
        
        return Integer.parseInt(sb.toString(), 10);
    }
    
    private int R(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        while (sb.length() < 4) sb.insert(0, "0");
        
        sb.insert(0, sb.substring(3, 4));
        sb.deleteCharAt(4);
        
        return Integer.parseInt(sb.toString(), 10);
    }
}