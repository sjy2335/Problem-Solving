import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 숫자 1개로 표현
        // 숫자 2개로 표현은 1개에 1개, NN
        // 숫자 3개로 표현은 1개에 2개, 2개에 1개, NNN
        // 숫자 4개로 표현은 1개에 3개, 2개에 2개, 3개에 1개, NNNN
		List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        int NNs = 0;
        for (int i = 1; i <= 8; i++) {
            dp.add(new HashSet<>());
            NNs = NNs * 10 + N;
            dp.get(i).add(NNs);
        }
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int n1: dp.get(j))  {
                    for (int n2: dp.get(i - j)) {
                        dp.get(i).add(n1 + n2);
                        dp.get(i).add(n1 - n2);
                        dp.get(i).add(n1 * n2);
                        if (n2 != 0) dp.get(i).add(n1 / n2);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}