import java.io.*;
import java.util.*;

public class Main {

    private final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (TC-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<int[]>[] adj = new List[N];
            for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken());
                adj[S].add(new int[]{E, T});
                adj[E].add(new int[]{S, T});
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()) - 1;
                int E = Integer.parseInt(st.nextToken()) - 1;
                int T = Integer.parseInt(st.nextToken()) * -1;
                adj[S].add(new int[]{E, T});
            }

            // 모든 정점을 시작 정점으로 두고 음수 사이클 체크
            boolean negativeCycleFound = false;
            for (int start = 0; start < N; start++) {
                if (bellmanFord(start, N, adj)) {
                    negativeCycleFound = true;
                    break; // 하나라도 찾으면 출력
                }
            }

            if (negativeCycleFound) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }

    private boolean bellmanFord(int start, int N, List<int[]>[] adj) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean updated;
        for (int i = 0; i < N; i++) { // (N - 1) + 1번에 걸쳐
            updated = false;
            for (int j = 0; j < N; j++) { // j번과 인접한 정점들이 
                if (dist[j] == INF) continue;
                for (int[] nextNode : adj[j]) { // j번을 거쳐오면 빨라지는지 확인
                    int next = nextNode[0];
                    int cost = nextNode[1];
                    if (dist[next] > dist[j] + cost) {
                        dist[next] = dist[j] + cost;
                        updated = true;
                        if (i == N - 1) return true; // 음의 사이클 발견하면 조기 반환
                    }
                }
            }
            if (!updated) break; // 더이상 갱신되지 않으면 종료
        }
        return false;
    }
}