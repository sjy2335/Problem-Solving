import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N + 1];
        int[] caches = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            caches[i] = prices[i];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                caches[j] = Math.max(caches[j], caches[j - i] + prices[i]);
            }
        }
        
        System.out.println(caches[N]);
        
    }
}