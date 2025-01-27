import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] result = new int[commands.length];
        
		for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int[] sliced = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
            Arrays.sort(sliced);
            result[i] = sliced[cmd[2] - 1];
        }
        
        return result;
    }
}