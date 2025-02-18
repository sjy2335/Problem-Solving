import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int length = 2 * N + 1;

        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
            sb.append(i % 2 == 0 ? "I" : "O");
        String PN = sb.toString();

        int answer = 0;
        for (int i = 0; i < M - length + 1; i++) {
            if (PN.equals(S.substring(i, i + length))) answer++;
        }

        System.out.println(answer);

    }
}
