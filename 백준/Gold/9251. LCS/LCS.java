import java.io.*;
import java.util.*;

public class Main {
    
    char[] S1, S2;
    int N1, N2;
    int[][] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        S1 = br.readLine().toCharArray();
        S2 = br.readLine().toCharArray();
        N1 = S1.length;
        N2 = S2.length;
        
        cache = new int[N1 + 1][N2 + 1];
        
        System.out.println(lcs());
    }
    
    private int lcs() {
        for (int i = 1; i <= N1; i++) {
            for (int j = 1; j <= N2; j++) {
                if (S1[i - 1] == S2[j - 1])
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                else 
                    cache[i][j] = Math.max(cache[i][j - 1], cache[i - 1][j]);
            }
        }
        
        return cache[N1][N2];
    }
}