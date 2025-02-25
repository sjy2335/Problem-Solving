import java.io.*;
import java.util.*;

public class Main {

    private int N;
    private int[][] arr;
    private int[] endRowDiff = {0, 1, 1};
    private int[] endColDiff = {1, 0, 1};


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backtrack(0, 0, 0));
    }

    private int backtrack(int prevR, int prevC, int shape) {
        int r = prevR + endRowDiff[shape];
        int c = prevC + endColDiff[shape];
        if (r == N - 1 && c == N - 1) return 1;

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if ((i == 2 || shape == 2 || shape == i)
                && isValid(r, c, i))
                sum += backtrack(r, c, i);
        }

        return sum;
    }

    private boolean isValid(int startR, int startC, int shape) {
        if (shape == 0)
            return startR < N && startC + 1< N && arr[startR][startC + 1] == 0;
        if (shape == 1)
            return startR + 1 < N && startC < N && arr[startR + 1][startC] == 0;
        // if shape is 2
        return startR + 1 < N && startC + 1 < N &&
            arr[startR + 1][startC] == 0 &&
            arr[startR][startC + 1] == 0 &&
            arr[startR + 1][startC + 1] == 0;
    }
}
