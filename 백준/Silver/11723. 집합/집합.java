import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("all")) {
                set = IntStream.range(1, 21).boxed().collect(Collectors.toSet());
                continue;
            }

            if (cmd.equals("empty")) {
                set = new HashSet<>();
                continue;
            }

            int number = Integer.parseInt(st.nextToken());

            if (cmd.equals("add"))
                set.add(number);

            if (cmd.equals("remove"))
                set.remove(number);

            if (cmd.equals("check"))
                sb.append(set.contains(number) ? 1 : 0).append("\n");

            if (cmd.equals("toggle"))
                if (!set.remove(number)) set.add(number);

        }

        System.out.println(sb);
    }
}
