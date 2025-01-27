import java.util.*;

class Solution {
    private static int N;
    private static int[] apeachInfo;
    private static int[] lionInfo;
    private static int maxScoreDiff;
    private static int[] result;

    private static void backtrack(int arrows, int scoreDiff, int idx) {

        if (idx == 11) {
            if (arrows < N) lionInfo[10] += N - arrows;
            if (scoreDiff > maxScoreDiff) {
                maxScoreDiff = scoreDiff;
                result = lionInfo.clone();
            } else if (scoreDiff == maxScoreDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (lionInfo[i] > result[i]) {
                        result = lionInfo.clone();
                        break;
                    } else if (lionInfo[i] < result[i]) {
                        break;
                    }
                }
            }
            if (arrows < N) lionInfo[10] -= N - arrows;
            return;
        }

        if (arrows + apeachInfo[idx] + 1 <= N) {
            lionInfo[idx] = apeachInfo[idx] + 1;
            int newScoreDiff = scoreDiff + (10 - idx);
            if (apeachInfo[idx] > 0) newScoreDiff += (10 - idx);
            backtrack(arrows + lionInfo[idx], newScoreDiff, idx + 1);
            lionInfo[idx] = 0;
        }

        backtrack(arrows, scoreDiff, idx + 1);
    }

    public int[] solution(int n, int[] info) {
        N = n;
        apeachInfo = info;
        lionInfo = new int[11];
        result = new int[11];
        maxScoreDiff = 0;

        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] > 0) apeachScore += (10 - i);
        }

        backtrack(0, -apeachScore, 0);

        if (maxScoreDiff <= 0) return new int[]{-1};
        return result;
    }
}