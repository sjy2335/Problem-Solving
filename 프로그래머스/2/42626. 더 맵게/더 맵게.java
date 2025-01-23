import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s: scoville) {
            pq.add(s);
        }

        int answer = 0;
        while (pq.peek() < K && pq.size() > 1)  {
            int least = pq.poll();
            int secondLeast = pq.poll();
            pq.add(least + secondLeast * 2);
            answer++;
        }
        
        if (pq.peek() < K) return -1;
        
        return answer;
    }
}