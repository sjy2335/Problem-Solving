import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        
        List<Integer> result = new ArrayList<>();
        for (int a: A) {
            int pos = Collections.binarySearch(result, a);
            if (pos < 0) pos = (pos + 1) * -1;
            
            if (pos == result.size()) result.add(a);
            else result.set(pos, a);
        }
        
        bw.write(result.size() + "\n");
        bw.close();
    }
}