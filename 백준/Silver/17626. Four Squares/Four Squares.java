import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(br.readLine());
        int[] cache = new int[n + 1];
    
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        // 대략적으로 n * root_n 시간복잡도, 약 천만?
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
            }
        }
    
        bw.write(cache[n] + "\n");
        bw.close();
    }
}