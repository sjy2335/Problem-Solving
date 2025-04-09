import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            bw.write(bertrands(n) + "\n");
        }
        bw.close();
    }

    private int bertrands(int n) {
        int re = n * 2; // right end

        boolean[] primeFlags = new boolean[re + 1];
        Arrays.fill(primeFlags, true);
        primeFlags[0] = false;
        primeFlags[1] = false;

        int reRoot = (int) Math.sqrt(re);
        for (int i = 2; i <= reRoot; i++) {
            if (!primeFlags[i])
                continue;
            for (int j = i; j <= re; j += i) {
                primeFlags[j] = false;
            }
        }

        int answer = 0;
        for (int i = n + 1; i <= re; i++) {
            if (primeFlags[i]) answer++;
        }

        return answer;
    }

}
