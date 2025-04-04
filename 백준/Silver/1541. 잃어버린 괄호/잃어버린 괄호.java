import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        // '-'가 한번이라도 나오면, 그 이후는 상관 없이 전부 다 빼면 됨
        int answer = 0;
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c))
                sb.append(c);
            else {
                answer += Integer.parseInt(sb.toString()) * (negative ? -1 : 1);
                sb.setLength(0);
                if (c == '-') negative = true;
            }
        }
        answer += Integer.parseInt(sb.toString()) * (negative ? -1 : 1);

        bw.write(answer + "\n");
        bw.close();
    }
}
