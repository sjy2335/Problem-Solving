import java.io.*;
import java.util.*;

public class Main {

    Map<String, List<String>> map;
    Set<String> visited;

    StringBuilder sb;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String u = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            map.put(u, List.of(l, r));
        }

        sb = new StringBuilder();
        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");
        sb.append("\n");

        System.out.println(sb);
    }

    private void preorder(String parent) {
        String left = map.get(parent).get(0);
        String right = map.get(parent).get(1);

        sb.append(parent);
        if (!left.equals(".")) preorder(left);
        if (!right.equals(".")) preorder(right);
    }

    private void inorder(String parent) {
        String left = map.get(parent).get(0);
        String right = map.get(parent).get(1);

        if (!left.equals(".")) inorder(left);
        sb.append(parent);
        if (!right.equals(".")) inorder(right);
    }

    private void postorder(String parent) {
        String left = map.get(parent).get(0);
        String right = map.get(parent).get(1);

        if (!left.equals(".")) postorder(left);
        if (!right.equals(".")) postorder(right);
        sb.append(parent);
    }


}
