import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0; // Pn 개수
        int count = 0; // IOI 개수
        int i = 1;

        while (i < M - 1) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                if (count == N) {
                    answer++;
                    count--; // 슬라이딩 (맨 끝 IOI 없앰 처리)
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(answer);

    }
}
