class Solution {
    private final char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};
    private String target;
    private int count = 0;
    private int result = 0;

    public int solution(String word) {
        target = word;
        permute("");
        return result;
    }
    
    private void permute(String current) {
        if (current.equals(target)) {
            result = count;
            return;
        }
        
        count++;
        
        if (current.length() < 5) {
            for (char c: vowels) 
                permute(current + c);
        }
        
    }
    
}