// 32m
import java.io.*;
import java.util.*;

public class Main {

    private int N, min, max;
    private int[][] board;
    private Integer[][] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][3];
        cache = new Integer[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) max = Math.max(max, getMax(0, i));

        cache = new Integer[N][3];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) min = Math.min(min, getMin(0, i));

        bw.write(max + " " + min + "\n");
        bw.close();
    }

    private int getMax(int n, int index) {
        if (n == N) return 0;
        if (cache[n][index] != null) return cache[n][index];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(index - i) <= 1) {
                max = Math.max(max, getMax(n + 1, i) + board[n][index]);
            }
        }

        return cache[n][index] = max;
    }

    private int getMin(int n, int index) {
        if (n == N) return 0;
        if (cache[n][index] != null) return cache[n][index];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(index - i) <= 1) {
                min = Math.min(min, getMin(n + 1, i) + board[n][index]);
            }
        }

        return cache[n][index] = min;
    }
}
