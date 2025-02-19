import java.io.*;
import java.util.*;

public class Main {

    List<String> result;
    int[] arr;
    int N, M;
    boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        result = new ArrayList<>();
        backtrack(0, new StringBuilder());

        for (String s: result) {
            bw.write(s);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private void backtrack(int m, StringBuilder sb) {
        if (m == M) {
            result.add(sb.toString().trim());
            return;
        }

        int prevLength = sb.length();

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtrack(m + 1, sb.append(arr[i]).append(" "));
            visited[i] = false;
            sb.setLength(prevLength);
        }
    }
}
