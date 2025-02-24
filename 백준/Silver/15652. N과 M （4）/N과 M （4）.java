import java.io.*;
import java.util.*;

public class Main {

    private List<List<Integer>> result;
    private int N, M;
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        result = new ArrayList<>();
        f(new ArrayList<>());
        
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list: result) {
            for (int number: list) {
                sb.append(number).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        
        bw.write(sb.toString());
        bw.close();
    }
    
    private void f(List<Integer> list) {
        if (list.size() == M) {
            result.add(List.copyOf(list));
            return;
        }
        
        int last = 0;
        if (list.size() > 0) last = list.get(list.size() - 1);
        for (int i = 1; i <= N; i++) {
            if (i < last) continue;
            list.add(i);
            f(list);
            list.remove(list.size() - 1);
        }
    }
}