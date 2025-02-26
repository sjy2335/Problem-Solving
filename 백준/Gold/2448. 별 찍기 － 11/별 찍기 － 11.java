import java.io.*;

public class Main {

    private int N, K;
    private String[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = 0;
        int tmp = 3;
        while (tmp < N) {
            tmp *= 2;
            K++;
        }
        cache = new String[11];

        bw.write(generateStar(K));
        bw.close();
    }

    private String generateStar(int k) {
        if (k == 0)
            return "  *  \n * * \n*****";
        if (cache[k] != null)
            return cache[k];

        String[] parts = generateStar(k - 1).split("\n");
        int blanks = 3 * (int) Math.pow(2, k - 1);

        StringBuilder sb = new StringBuilder();

        // 위에 이전 것 얹기
        for (String part: parts) {
            sb.append(" ".repeat(Math.max(0, blanks)));
            sb.append(part);
            sb.append(" ".repeat(Math.max(0, blanks)));
            sb.append("\n");
        }

        // 아래 이전 것 2개 두기
        for (String part: parts) {
            sb.append(part).append(" ").append(part).append("\n");
        }

        return cache[k] = sb.toString();
    }
}
