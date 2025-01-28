import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] splitted = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(splitted, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
                        
        int[][] set = new int[splitted.length][];
        for (int i = 0; i < splitted.length; i++) {
            set[i] = Arrays.stream(splitted[i].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set[i].length; j++) {
                if (!answer.contains(set[i][j])) answer.add(set[i][j]);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}