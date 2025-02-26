class Solution {
    public int solution(int[] a) {
        int N = a.length;
        if (N <= 3) return N;
        
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < N; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        
        int leftMin = a[0];
        int leftCount = 0;
        for (int i = 0; i < minIndex; i++) {
            if (leftMin >= a[i]) {
                leftMin = a[i];
                leftCount++;
            }
        }

        int rightMin = a[N - 1];
        int rightCount = 0;
        for (int i = N - 1; i > minIndex; i--) {
            if (rightMin >= a[i]) {
                rightMin = a[i];
                rightCount++;
            }
        }
        
        return leftCount + 1 + rightCount;
        
    }
}