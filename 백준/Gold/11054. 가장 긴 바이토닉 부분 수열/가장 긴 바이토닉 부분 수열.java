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
        int[] arr = new int[N + 1];
        int[] cacheInc = new int[N + 1];
        int[] cacheDec = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 0번째부터 i번째로 가능한 증가하는 부분 수열 크기
        for (int i = 1; i <= N; i++) {
            cacheInc[i] = 1;  // 최소 길이 1로 시작
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    cacheInc[i] = Math.max(cacheInc[i], cacheInc[j] + 1);
                }
            }
        }

        // N번째부터 i번째로 가능한 감소하는 부분 수열 크기
        for (int i = N; i >= 1; i--) {
            cacheDec[i] = 1;  // 최소 길이 1로 시작
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j]) {
                    cacheDec[i] = Math.max(cacheDec[i], cacheDec[j] + 1);
                }
            }
        }

        // 증가 후 감소하는 부분 수열을 찾기
        int maxLength = 0;
        for (int i = 1; i <= N; i++) {
            if (cacheInc[i] > 1 && cacheDec[i] > 1) {  // 증가한 후 감소하는 부분만 고려
                maxLength = Math.max(maxLength, cacheInc[i] + cacheDec[i] - 1);  // 중복된 i를 빼기 위해 -1
            }
        }

        maxLength = Math.max(maxLength, Math.max(Arrays.stream(cacheInc).max().getAsInt(), Arrays.stream(cacheDec).max().getAsInt()));

        bw.write(maxLength + "\n");
        bw.close();
    }
}
