import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());        
        
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            treeSet.add(arr[i]);
        }

        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : treeSet) 
            rankMap.put(num, rank++);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(rankMap.get(arr[i])).append(" ");
        
        System.out.println(sb);
    }
}