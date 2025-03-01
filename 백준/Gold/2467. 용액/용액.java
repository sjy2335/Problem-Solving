import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i= 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        long[] answer = {arr[left], arr[right]};
        long minDiff = Math.abs(answer[0] + answer[1]);

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.close();
    }
}
