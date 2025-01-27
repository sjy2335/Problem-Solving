import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {

        int answer = 0;
        
        int first = 0;
        int last = people.length - 1;
        Arrays.sort(people);
        
        while (first < last) {
            if (people[first] + people[last] <= limit) {
                first++;
                last--;
            } else {
                last--;
            }
            answer++;
        }
        
        if (first == last) answer++;
        
        return answer;
    }
}