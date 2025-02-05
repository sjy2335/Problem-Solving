import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2, N);
        System.out.println(recursion(length, r, c, 0));
    }

    private int recursion(int length, int r, int c, int count) {
        if (length == 1) return count;

        int half = length / 2;

        if (r < half && c < half)
            return recursion(length / 2, r, c, count);

        if (r < half)
            return recursion(half, r, c - half, count + half * half);

        if (c < half)
            return recursion(half, r - half, c, count + half * half * 2);

        return recursion(half, r - half, c - half, count + half * half * 3);
    }
}
