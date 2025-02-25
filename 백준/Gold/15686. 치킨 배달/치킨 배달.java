import java.io.*;
import java.util.*;

public class Main {

    private int N, M;
    private List<int[]> homes = new ArrayList<>();
    private List<int[]> chickens = new ArrayList<>();
    private List<List<int[]>> chickenCombinations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) homes.add(new int[]{i, j});
                if (value == 2) chickens.add(new int[]{i, j});
            }
        }

        // 치킨집 M개를 선택하는 모든 조합을 생성
        generateCombinations(new ArrayList<>(), 0);

        // 최소 치킨 거리 계산
        int minDistance = Integer.MAX_VALUE;
        for (List<int[]> selectedChickens : chickenCombinations) {
            minDistance = Math.min(minDistance, getTotalChickenDistance(selectedChickens));
        }

        bw.write(minDistance + "\n");
        bw.close();
    }

    // 조합을 구하는 백트래킹
    private void generateCombinations(List<int[]> selected, int start) {
        if (selected.size() == M) {
            chickenCombinations.add(new ArrayList<>(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            generateCombinations(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 모든 집에 대해 치킨 거리 합을 계산
    private int getTotalChickenDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] home : homes) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens)
                minDist = Math.min(minDist, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
            totalDistance += minDist;
        }

        return totalDistance;
    }
}
