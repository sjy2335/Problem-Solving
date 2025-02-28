import java.util.*;

class Solution {
    
//     private int[] money;
//     private int m;
//     private Integer[][] cache;
    
    private final int MODIFIER = 1_000_000_007;
    
//     // Top-down approach
//     public int solution(int n, int[] moneyInput) {
//         money = moneyInput;
//         m = money.length;
//         cache = new Integer[m][n + 1];
        
//         return dp(0, n) % MODIFIER;
//     }
    
//     // i번째부터 사용, j원을 만드는 경우의 수
//     private int dp(int i, int j) {
//         if (i == m) {
//             if (j == 0) return 1;
//             return 0;
//         }
//         if (j < 0) return 0;
        
//         if (cache[i][j] != null) return cache[i][j];
        
//         // 사용하지 않는 & 사용하는 경우의 수
//         return cache[i][j] = (dp(i + 1, j) + dp(i, j - money[i])) % MODIFIER;
//     }
    
    
    //Bottom-up approach
    public int solution(int n, int[] money) {
        
        int[] cache = new int[n + 1];
        cache[0] = 1;
        
        for (int price: money) {
            for (int i = 0; i + price <= n; i++)
                cache[i + price] = (cache[i + price] + cache[i]) % MODIFIER;
        }
        
        return cache[n] % MODIFIER;
    }
   
}