import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, String> childParentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            childParentMap.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }
        
		for (int i = 0; i < seller.length; i++) {
            String crnt = seller[i];
            int profit = amount[i] * 100;
            while (!crnt.equals("-") && profit > 0) {
                int parentProfit = profit / 10;
                int ownProfit = profit - parentProfit;
                profitMap.put(crnt, profitMap.get(crnt) + ownProfit);
                crnt = childParentMap.get(crnt);
                profit = parentProfit;
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        
        return answer;
    }
}