import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] marked;
    static List<int[]> crosses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        marked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        findCrosses();

        if (!validate()) {
            System.out.println(-1);
        } else {
            System.out.println(crosses.size());
            for (int[] cross : crosses) {
                System.out.println(cross[0] + " " + cross[1] + " " + cross[2]);
            }
        }
    }

    private static void findCrosses() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (board[i][j] == '*') {
                    int size = getMaxCrossSize(i, j);
                    if (size > 0) {
                        crosses.add(new int[]{i + 1, j + 1, size});
                        markCross(i, j, size);
                    }
                }
            }
        }
    }

    private static int getMaxCrossSize(int x, int y) {
        int size = 0;
        while (true) {
            // 이전에서 확장이 가능한지 보고, 확장 (시작은 0)
            int nx1 = x - (size + 1), nx2 = x + (size + 1);
            int ny1 = y - (size + 1), ny2 = y + (size + 1);
            if (nx1 < 0 || nx2 >= N || ny1 < 0 || ny2 >= M) break;
            if (board[nx1][y] != '*' || board[nx2][y] != '*' || board[x][ny1] != '*' || board[x][ny2] != '*') break;
            size++;
        }
        return size;
    }

    private static void markCross(int x, int y, int size) {
        marked[x][y] = true;
        for (int i = 1; i <= size; i++) {
            marked[x - i][y] = true;
            marked[x + i][y] = true;
            marked[x][y - i] = true;
            marked[x][y + i] = true;
        }
    }

    private static boolean validate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '*' && !marked[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}