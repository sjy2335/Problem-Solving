import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        String result = explode(str, bomb);
        if (result.isEmpty()) result = "FRULA";
        bw.write(result + "\n");
        bw.close();
    }

    private String explode(String str, String bomb) {
        StringBuilder sb = new StringBuilder();
        int bombLength = bomb.length();

        for (char c : str.toCharArray()) {
            sb.append(c);

            if (sb.length() >= bombLength &&
                sb.substring(sb.length() - bombLength).equals(bomb)) {
                sb.delete(sb.length() - bombLength, sb.length());
            }
        }

        return sb.toString();
    }
}
