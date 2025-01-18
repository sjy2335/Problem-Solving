import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            String player = completion[i];
            if (map.containsKey(player)) {
                map.put(player, map.get(player) + 1);
            } else {
            	map.put(player, 1);
            }
        }
        
		for (int i = 0; i < participant.length; i++) {
            String player = participant[i];
            if (map.get(player) == null || map.get(player) == 0) {
                return player;
            } else {
                map.put(player, map.get(player) - 1);
            }
        }
        return "";
    }
}