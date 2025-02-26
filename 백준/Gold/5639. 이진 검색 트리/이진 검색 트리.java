import java.io.*;

public class Main {

    private BufferedWriter bw;

    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        void insert(Node node) {
            if (node.value < this.value) {
                if (this.left == null) this.left = node;
                else this.left.insert(node);
            }
            else {
                if (this.right == null) this.right = node;
                else this.right.insert(node);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = null;
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            Node node = new Node(Integer.parseInt(input));
            if (root == null) root = node;
            else root.insert(node);
        }

        traversePostorder(root);

        bw.close();
    }

    private void traversePostorder(Node node) throws IOException {
        if (node.left != null) traversePostorder(node.left);
        if (node.right != null) traversePostorder(node.right);
        bw.write(node.value + "\n");
    }
}
