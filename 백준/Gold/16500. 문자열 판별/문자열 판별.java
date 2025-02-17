import java.io.*;

public class Main {

    private String S;
    private int K;
    private int N;
    private String[] words;
    private Boolean[] cache;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        K = S.length();
        N = Integer.parseInt(br.readLine());

        words = new String[N];
        for (int i = 0; i < N; i++) words[i] = br.readLine();

        cache = new Boolean[K + 1];

        System.out.println(determine(0) ? 1 : 0);
    }

    // k번째 문자까지 이미 만족한다 했을 때 앞으로 만족할 수 있는지 판별
    private boolean determine(int k) {
        if (k >= K) return true;  // K번째까지 만족하면 true
        if (cache[k] != null) return cache[k];

        boolean result = false;
        for (String w : words) {
            if (k + w.length() <= K && S.startsWith(w, k)) 
                result = result || determine(k + w.length());
        }

        return cache[k] = result;
    }

}
