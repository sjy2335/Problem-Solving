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
        int[] x = new int[N];
        int[] y = new int[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());    
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;  // 마지막 점은 첫번째 점과
            sum1 += (long) x[i] * y[j];
            sum2 += (long) y[i] * x[j];
        }
        double area = Math.abs(sum1 - sum2) / 2.0;
        
        bw.write(String.format("%.1f\n", area));
        bw.close();
    }
}