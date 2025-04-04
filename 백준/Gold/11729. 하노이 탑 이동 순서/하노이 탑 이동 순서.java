import java.io.*;
import java.util.*;

public class Main {
    private List<int[]> answer;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write((int) Math.pow(2, N) - 1 + "\n");
        printMoves(N, 1, 3, bw);
        bw.close();
    }

    private void printMoves(int N, int from, int to, BufferedWriter bw) throws IOException{
        if (N == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }
        int tmp = 6 - from - to; // from + tmp + to = 6
        printMoves(N - 1, from, tmp, bw);
        bw.write(from + " " + to + "\n");
        printMoves(N - 1, tmp, to, bw);
    }

}
