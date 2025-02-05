import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        int answer = -1;
        for (int i = 0; i < N - 2; i++) {
            if (arr[i] + arr[i + 1] > arr[i + 2])
                answer = arr[i] + arr[i + 1] + arr[i + 2];
        }
        
        System.out.println(answer);
    }
}