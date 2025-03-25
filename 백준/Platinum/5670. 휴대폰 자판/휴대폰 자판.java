import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            Trie root = new Trie();
            int N = Integer.parseInt(input);
            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                root.insert(chars, 0);
            }
            sb.append(String.format("%.2f\n", root.getAverageTypings(N)));
        }
        System.out.println(sb);
    }

    private static class Trie {
        private final int MAX_CHILDREN = 26;
        private final Trie[] children;
        private int branches;
        private int words;

        Trie() {
            children = new Trie[MAX_CHILDREN];
        }

        private void insert(char[] chars, int idx) {
            if (idx >= chars.length) {
                branches++;
                return;
            }
            int cn = chars[idx] - 'a';
            if (children[cn] == null) {
                branches++;
                children[cn] = new Trie();
            }
            words++;
            children[cn].insert(chars, idx+1);
        }

        private float getAverageTypings(int N) {
            return (float) countTypings(true) / (long) N;
        }

        private long countTypings(boolean isRoot) {
            long result = isRoot || branches > 1 ? words : 0;
            for (int i = 0; i < MAX_CHILDREN; i++)
                if (children[i] != null) result += children[i].countTypings(false);
            return result;
        }
    }

}
