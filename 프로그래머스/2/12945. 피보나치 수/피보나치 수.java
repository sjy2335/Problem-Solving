class Solution {
    
    private static int[] fibo;
    
    private int findFibo(int i) {
        
        if (i == 0) return fibo[0] = 0;
        if (i == 1) return fibo[1] = 1;
        if (fibo[i] != 0) return fibo[i];
        
        return fibo[i] = (findFibo(i - 1) + findFibo(i - 2)) % 1234567;
    }
    
    public int solution(int n) {
        
        fibo = new int[n+1];

        return findFibo(n) % 1234567;
    }
}