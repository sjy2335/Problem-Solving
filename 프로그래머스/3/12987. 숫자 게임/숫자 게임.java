import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = 0, indexA = 0, indexB = 0;
        
        while (indexA < A.length && indexB < B.length) {
            if (B[indexB++] > A[indexA]) {
                count++;
                indexA++;
            }
        }

        return count;
    }
}