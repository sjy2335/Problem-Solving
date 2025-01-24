import java.util.*;

class Solution {
    
    private static class Truck {
        int weight, time;
        
        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        int crntWeight = 0;
        
        ArrayDeque<Truck> waiting = new ArrayDeque<>();
        ArrayDeque<Truck> passing = new ArrayDeque<>();
        
        for (int w: truck_weights) {
            waiting.add(new Truck(w, 0));
        }
        
		Truck crnt = waiting.poll();
        passing.add(crnt);
        answer++;
        
        crntWeight += crnt.weight;
        
        while (!passing.isEmpty()) {
            
            answer++;
            for (Truck t: passing) t.time++;
            
            crnt = passing.peek();
            
            if (crnt.time >= bridge_length) {
                crntWeight -= crnt.weight;
                passing.poll();
            }
            
            if (!waiting.isEmpty() && waiting.peek().weight + crntWeight <= weight) {
                crntWeight += waiting.peek().weight;
                passing.add(waiting.poll());
            }
        }
        
        
        return answer;
    }
}