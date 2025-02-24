import java.io.*;
import java.util.*;

public class Main {

    private int N, M;
    private int[] arr;
    private int[] result;
    private StringBuilder sb;
    private Set<String> set;


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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        sb = new StringBuilder();
        result = new int[M];
        set = new HashSet<>();

        f(0, 0);

        bw.write(sb.toString());
        bw.close();
    }

    private void f(int depth, int start) {
        if (depth == M) {
            for (int r : result) sb.append(r).append(" ");
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) continue; // 같은 자리에 같은 숫자는 허용 안함!!
            result[depth] = arr[i];
            prev = arr[i];
            f(depth + 1, i);
        }
    }
}
