import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] statements = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            statements[i] = Integer.parseInt(st.nextToken());
        }

        int maxValidAnswer = -1;

        // Try each possible number of true statements (0 to N)
        for (int trueCount = 0; trueCount <= N; trueCount++) {
            int actualTrueCount = 0;

            // Check if each statement would be true or false given the assumption
            for (int i = 0; i < N; i++) {
                boolean isStatementTrue = (statements[i] == trueCount);
                if (isStatementTrue) {
                    actualTrueCount++;
                }
            }

            // If the assumption matches reality, use it as valid answer
            if (actualTrueCount == trueCount) {
                maxValidAnswer = Math.max(maxValidAnswer, trueCount);
            }
        }

        System.out.println(maxValidAnswer);
    }
}
