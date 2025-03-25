import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean validFlag = true;
            Trie root = new Trie();

            while (n-- > 0) {
                String phoneNumbers = br.readLine();
                boolean result = root.insert(phoneNumbers, 0);
                if (!result) {
                    validFlag = false;
                }
            }
            sb.append(validFlag ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    private static class Trie {
        final int NUMBERS = 10;
        boolean terminated, continued;
        Trie[] children;

        Trie() {
            this.children = new Trie[NUMBERS];
        }

        boolean insert(String numbers, int idx) {
            if (idx >= numbers.length()) {
                terminated = true;
                return !continued;
            }

            int number = numbers.charAt(idx) - '0';
            if (children[number] == null) {
                children[number] = new Trie();
            }
            continued = true;

            return !terminated && children[number].insert(numbers, idx + 1);
        }

    }
}
