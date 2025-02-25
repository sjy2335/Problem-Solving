import java.io.*;
import java.util.*;

public class Main {

    private int[] parent;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] knowings = new int[T];
        for (int i = 0; i < T; i++) {
            knowings[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        List<List<Integer>> parties = new ArrayList<>();
        parent = new int[N];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());

            for (int j = 0; j < P; j++) {
                int c = Integer.parseInt(st.nextToken()) - 1;
                parties.get(i).add(c);
                if (j > 0) union(c, parties.get(i).get(j - 1));
            }
        }

        int answer = 0;
        for (List<Integer> party: parties) {
            boolean valid = true;
            peopleLoop: for (int p: party) {
                for (int k: knowings) {
                    if (find(k) == find(p)) {
                        valid = false;
                        break peopleLoop;
                    }
                }
            }
            if (valid) answer++;
        }

        System.out.println(answer);
    }

    private int find(int c) {
        if (parent[c] == -1)
            return c;

        return find(parent[c]);
    }

    private void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent == bParent) return;

        parent[aParent] = bParent;
    }
}
