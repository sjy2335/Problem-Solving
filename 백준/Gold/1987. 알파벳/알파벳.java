import java.io.*;
import java.util.*;

public class Main {

    private int R, C;
    private char[][] board;
    private final int[] dr = {-1, 0, 0, 1};
    private final int[] dc = {0, -1, 1, 0};
    private Set<Character> set;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        readAndParseInput();

        set = new HashSet<>();
        set.add(board[0][0]);
        System.out.println(backtrack(0, 0) + 1);
    }

    private void readAndParseInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++)
            board[i] = br.readLine().toCharArray();
    }

    private int backtrack(int r, int c) {
        if (r == R || c == C) return 0;

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isValid(nr, nc)) continue;
            if (set.contains(board[nr][nc])) continue;

            set.add(board[nr][nc]);
            max = Math.max(max, backtrack(nr, nc) + 1);
            set.remove(board[nr][nc]);
        }

        return max;
    }

    private boolean isValid(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }
}
