import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(generateStars(N));

        bw.close();
    }

    private String generateStars(int N) {
        if (N == 3) {
            return "***\n* *\n***";
        }

        String prev = generateStars(N / 3);
        String[] parts = prev.split("\n");

        StringBuilder sb = new StringBuilder();
        for (String part: parts) {
            sb.append(part.repeat(3));
            sb.append("\n");
        }

        for (String part: parts) {
            sb.append(part);
            sb.append(" ".repeat(N / 3));
            sb.append(part).append("\n");
        }

        for (String part: parts) {
            sb.append(part.repeat(3));
            sb.append("\n");
        }

        return sb.toString();
    }
}
