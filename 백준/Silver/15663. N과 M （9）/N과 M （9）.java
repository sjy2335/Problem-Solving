import java.io.*;
import java.util.*;

public class Main {

    int N, M;
    int[] arr;
    boolean[] visited;
    Set<List<Integer>> result;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        result = new LinkedHashSet<>();

        backtrack(0, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for (List<Integer> nums: result) {
            for (int n: nums) sb.append(n).append(" ");
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }

        System.out.println(sb);
    }

    private void backtrack(int count, List<Integer> list) {
        if (count == M) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(arr[i]);

            backtrack(count + 1, list);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
