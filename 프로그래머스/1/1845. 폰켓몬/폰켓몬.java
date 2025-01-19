import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monsterSet = new HashSet<>();
        for (int n : nums) {
            monsterSet.add(n);
        }
       	return monsterSet.size() > nums.length / 2 ? nums.length / 2  : monsterSet.size();
    }
}