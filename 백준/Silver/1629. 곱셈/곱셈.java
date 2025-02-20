import java.io.*;
import java.util.*;

public class Main {

    long A, C;
    int B;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(B));
    }

    private long pow(int n) {
        if (n == 1) return A % C;

        long tmp = pow(n / 2);

        if (n % 2 == 1)
            return (tmp * tmp % C) * A % C;

        return tmp * tmp % C;
    }
}
