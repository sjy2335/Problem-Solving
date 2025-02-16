import java.io.*;
import java.util.*;

public class Main {
    
    private int N;
    private int[] arr;
    private int[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        cache = new int[N];
        
        int result = 0;
        for (int i = 0; i < N; i++) 
            result = Math.max(result, LIS(i));

        System.out.println(result);
    }
    
    // end로 끝나는 LIS 길이
    private int LIS(int end) {
        
        if (cache[end] != 0) return cache[end];
        
        cache[end] = 1;
        
        for (int i = 0; i < end; i++) 
            if (arr[i] < arr[end]) cache[end] = Math.max(cache[end], LIS(i) + 1);
        
        return cache[end];
    }
}