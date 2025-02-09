import java.util.*;

class Solution {
    public int solution(String name) {
        int N = name.length();
        int move = N - 1; // 오른쪽으로만 이동할 때
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < N && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i + N - next + Math.min(i, N - next));
        }

        return answer + move;
    }
}