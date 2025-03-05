import java.io.*;
import java.util.*;

public class Main {

    private int n, m, r;
    private int[] values;
    private int[][] dist;
    private final int INF = 10000;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지역 개수 n, 수색 범위 m, 길의 개수 r
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 각 낙하 지점의 아이템 수 values[]
        values = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) values[i] = Integer.parseInt(st.nextToken());

        // floyd-warshall을 위한 거리 배열 초기화
        dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());
            dist[a][b] = l;
            dist[b][a] = l;
        }

        // 모든 정점 사이 최단거리 계산하기
        // k = [0 ~ N)의 정점만을 사용한다고 할 때
        // k번을 거쳐가면 빨라지는가?
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int detour = dist[i][k] + dist[k][j];
                    if (dist[i][j] > detour)
                        dist[i][j] = detour;
                }
            }
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= m) count += values[j];
            }
            maxCount = Math.max(maxCount, count);
        }

        bw.write(maxCount+"\n");
        bw.close();

    }
}