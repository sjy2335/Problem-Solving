import java.util.*;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        permutation("", numbers);
        
        int count = 0;
        for (int number: set) {
            if (isPrime(number)) count++;
        }
        
        return count;
    }
    
    private void permutation(String current, String remaining) {
        if (current.length() != 0) 
            set.add(Integer.parseInt(current));
        
        for (int i = 0; i < remaining.length(); i++) {
            permutation(current + remaining.charAt(i),
                        remaining.substring(0, i) + 
                        remaining.substring(i + 1));
        }
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        
        for (int i = 2; i * i <= number; i++) 
            if (number % i == 0) return false;
        
        return true;
    }
}