import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int a: arr) {
            if (dq.isEmpty() || dq.getLast() != a) dq.add(a);
        }
        
        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}