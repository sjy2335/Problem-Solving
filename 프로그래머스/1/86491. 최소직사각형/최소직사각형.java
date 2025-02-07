import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        int maxLength = 0;
        for (int[] size: sizes) 
            maxLength = Math.max(maxLength, Math.max(size[0], size[1]));

		ArrayList<Integer> list = new ArrayList<>();
        for (int[] size: sizes) {
            list.add(Math.min(size[0], size[1]));
        }
        
        return maxLength * list.stream().max().getAsInt();
    }
}