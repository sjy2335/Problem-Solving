import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = N;
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (--N >= 0) times[N] = Integer.parseInt(st.nextToken());

        Arrays.sort(times);

        int[] answer = new int [n];
        answer[0] = times[0];
        for (int i = 1; i < n; i++) answer[i] += answer[i - 1] + times[i];

        System.out.println(Arrays.stream(answer).reduce(Integer::sum).getAsInt());
    }
}
