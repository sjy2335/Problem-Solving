import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] plumTree = new int[T];
        for (int i = 0; i < T; i++) {
            plumTree[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T+1][W+1][3];
        for (int t = 0; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                Arrays.fill(dp[t][w], -1);
            }
        }

        dp[0][0][1] = 0;
        dp[1][1][2] = plumTree[0] == 2 ? 1 : 0;

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                for (int p = 1; p <= 2; p++) {
                    if (dp[t-1][w][p] != -1) {
                        if (p == plumTree[t-1])
                            dp[t][w][p] = Math.max(dp[t][w][p], dp[t-1][w][p] + 1);
                        else
                            dp[t][w][p] = Math.max(dp[t][w][p], dp[t-1][w][p]);
                    }
                    if (w > 0) {
                        int otherTree = 3 - p;
                        if (dp[t-1][w-1][otherTree] != -1) {
                            if (otherTree == plumTree[t-1])
                                dp[t][w][p] = Math.max(dp[t][w][p], dp[t-1][w-1][otherTree] + 1);
                            else
                                dp[t][w][p] = Math.max(dp[t][w][p], dp[t-1][w-1][otherTree]);
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <= W; w++) {
            for (int p = 1; p <= 2; p++) {
                answer = Math.max(answer, dp[T][w][p]);
            }
        }
        System.out.println(answer);
    }
}
