import java.io.*;
import java.util.*;

public class Main {

    Map<Long, int[][]> cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        cache = new HashMap<>();

        int[][] result = powMatrix(A, B, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] % 1000 + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    private int[][] multipleMatrix(int[][] mat1, int[][] mat2, int N) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (mat1[i][k] * mat2[k][j]) % 1000;
                }
                result[i][j] %= 1000;
            }
        }

        return result;
    }

    private int[][] powMatrix(int[][] A, long B, int N) {
        if (B == 1L) return A;
        if (cache.containsKey(B)) return cache.get(B);

        int[][] prev = powMatrix(A, B / 2L, N);
        int[][] result = multipleMatrix(prev, prev, N);

        if (B % 2 == 1) {
            result = multipleMatrix(result, A, N);
        }

        cache.put(B, result);
        return result;
    }
}
