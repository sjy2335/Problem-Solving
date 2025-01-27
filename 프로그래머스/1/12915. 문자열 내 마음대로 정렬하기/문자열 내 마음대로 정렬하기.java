import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {

        Comparator<String> comparator = new Comparator<>() {
            public int compare (String a, String b) {
                char nthA = a.charAt(n);
                char nthB = b.charAt(n);
                if (nthA != nthB) return Character.compare(nthA, nthB);
                return a.compareTo(b);
            }
        };
        
        Arrays.sort(strings, comparator);
        
        return strings;
        
    }
}