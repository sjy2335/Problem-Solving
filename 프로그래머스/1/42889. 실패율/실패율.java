import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stagePlayers = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            stagePlayers[stages[i]]++;
        }
        
        HashMap<Integer, Double> failRates = new HashMap<>();        
        double challengedPlayers = stages.length;
        
        for (int i = 1; i < N + 1; i++) {
            if (stagePlayers[i] == 0) failRates.put(i, 0.);
            else {
                failRates.put(i, stagePlayers[i] / challengedPlayers);
            }
            challengedPlayers -= stagePlayers[i];
        }
        
        return failRates.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
    }
}