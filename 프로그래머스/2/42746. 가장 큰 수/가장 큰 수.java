import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int n: numbers) {
            list.add(String.valueOf(n));
        }
        
        list.sort((s1, s2) -> {
            int a = Integer.parseInt(s1+s2);
            int b = Integer.parseInt(s2+s1);
            return Integer.compare(b, a);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s: list) {
            sb.append(s);
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}