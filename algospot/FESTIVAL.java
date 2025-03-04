import java.util.*;
import java.io.*;

public class Main {

	private int N, L;
	private int[] prices;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int C = Integer.parseInt(br.readLine());
		while (C-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			prices = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) prices[i] = Integer.parseInt(st.nextToken());

			double avg = Double.MAX_VALUE;
			for (int i = 0; i < N - L + 1; i++) {
				int sum = 0;
				int count = 0;
				for (int j = i; j < N; j++) {
					sum += prices[j];
					count++;
					if (count >= L) avg = Math.min(avg, (double) sum / count);
				}
			}

			bw.write(avg + "\n");
		}
		bw.close();
	}

}
