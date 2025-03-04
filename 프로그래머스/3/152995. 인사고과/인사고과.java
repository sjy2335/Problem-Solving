import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        int[] wanho = scores[0];
        
        // 우선 첫번째 점수 기준으로 내림차순 정렬, 같다면 두번째 점수 기준으로 오름차순 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int maxSecondScore = 0;
        List<int[]> validScores = new ArrayList<>();
        for (int[] score: scores) {
	        // 앞에서 현재보다 큰 두번째 점수가 나왔으면 목록에 포함 안함
            if (score[1] < maxSecondScore) {
                if (Arrays.equals(wanho, score)) return -1;
                continue;
            }
            maxSecondScore = Math.max(maxSecondScore, score[1]);
            validScores.add(score);
        }
        
        int wanhoSum = wanho[0] + wanho[1];
        int wanhoRank = 1;
        for (int[] score: validScores) {
            if (score[0] + score[1] > wanhoSum) wanhoRank++;
        }
        
        return wanhoRank;
    }
}