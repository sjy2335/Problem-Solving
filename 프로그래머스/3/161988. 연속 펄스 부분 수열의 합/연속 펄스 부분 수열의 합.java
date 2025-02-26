import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        
        // 원래 수열에 펄스 수열 곱한 2가지 수열 만들기
        int[] pulsed1 = Arrays.copyOf(sequence, N);
        for (int i = 0; i < N; i++) 
            pulsed1[i] *= i % 2 == 0 ? 1 : -1;
        
        int[] pulsed2 = Arrays.copyOf(sequence, N);
        for (int i = 0; i < N; i++) 
            pulsed2[i] *= i % 2 == 0 ? -1 : 1;
        
        
        // 각 수열에 대해 누적된 합을 더한 수열 만들기
        long[] accumulated1 = new long[N];
        for (int i = 0; i < N; i++) 
            accumulated1[i] += (long) pulsed1[i] + (i > 0 ? accumulated1[i - 1] : 0L);
        
        long[] accumulated2 = new long[N];
        for (int i = 0; i < N; i++) 
            accumulated2[i] += (long) pulsed2[i] + (i > 0 ? accumulated2[i - 1] : 0L);

        
        // 위 수열을 이용해 최대 연속 부분 수열 구하기
            // 어떻게? 50 C 2 조합은 시간 초과 발생할 것.
            // 가장 큰 값에서 가장 작은 값을 빼기!
        long result1 = getLargestPulseSequenceSum(accumulated1);
        long result2 = getLargestPulseSequenceSum(accumulated2);
        
        // 위의 두 값 중 큰 값 반환하기
        return Math.max(result1, result2);
    }
    
    private long getLargestPulseSequenceSum(long[] accumulated) {
        
        long maxAccumulated = Arrays.stream(accumulated).max().getAsLong();
        long minAccumulated = Arrays.stream(accumulated).min().getAsLong();
        
        return Math.max(maxAccumulated, maxAccumulated - minAccumulated);
    }
}