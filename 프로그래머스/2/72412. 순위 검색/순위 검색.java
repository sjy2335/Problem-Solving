import java.util.*;

class Solution {
    
    private Map<String, List<Integer>> map;
    private List<String> keys;
    
    public int[] solution(String[] info, String[] query) {
        
        map = new HashMap<>();
        
        for (String s: info) {
            String[] profile = s.split(" ");
            
            keys = new ArrayList<>();
            combinate(profile, 0, new StringBuilder());
            
            for (String key: keys) {
                if (map.containsKey(key)) map.get(key).add(Integer.parseInt(profile[4]));
                else {
                    map.put(key, new ArrayList<>());
                    map.get(key).add(Integer.parseInt(profile[4]));
                }
            }
        }
        
        for (List<Integer> scores: map.values()) {
            Collections.sort(scores);
        }
        
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] qParts = query[i].replace(" and ", " ").split(" ");
            String key = qParts[0] + " " + qParts[1] + " " + qParts[2] + " " + qParts[3];
            int targetScore = Integer.parseInt(qParts[4]);
            
            if (!map.containsKey(key)) result[i] = 0;
            else result[i] = countQualified(map.get(key), targetScore);
        }
        
        return result;
        
    }
    
    private void combinate(String[] profile, int idx, StringBuilder sb) {
        if (idx == 4) {
            sb.deleteCharAt(sb.length() - 1);
            keys.add(sb.toString());
            return;
        }
        
        int originalLength = sb.length();
        sb.append("-").append(" ");
        combinate(profile, idx + 1, sb);
        sb.setLength(originalLength);
        
        sb.append(profile[idx]).append(" ");
        combinate(profile, idx + 1, sb);
        sb.setLength(originalLength);
    }
    
    private int countQualified(List<Integer> list, int targetScore) {
        
        int left = 0;
        int right = list.size() - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= targetScore) right = mid - 1;
            else left = mid + 1;
        }
        
        return list.size() - left;
    }
}