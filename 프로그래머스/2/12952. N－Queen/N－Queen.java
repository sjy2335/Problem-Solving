import java.util.*;

class Solution {
    
    private static int N;
    private static int answer;
    private static boolean[] vertical;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;
    
    private static void backtrack(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (vertical[col] || diagonal1[row + col] || diagonal2[row - col + N]) 
                continue;
            
            vertical[col] = diagonal1[row + col] = diagonal2[row - col + N] = true;
            backtrack(row + 1);
            vertical[col] = diagonal1[row + col] = diagonal2[row - col + N] = false;
        }
    }
    
    public int solution(int n) {
        N = n;
        answer = 0;
        
		vertical = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        
        backtrack(0);
        
        return answer;
    }
}