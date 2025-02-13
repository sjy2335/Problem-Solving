import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        List<String> route = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            System.out.println(cur);

            if (map.containsKey(cur) && !map.get(cur).isEmpty()) {
                stack.push(map.get(cur).poll());
            } else {
                route.add(stack.pop());
            }
        }

        Collections.reverse(route);
        return route.toArray(String[]::new);
    }
}

/*
class Solution {
    Map<String, PriorityQueue<String>> map;
    List<String> route;
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        route = new ArrayList<>();
        
        dfs("ICN");

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    private void dfs(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            dfs(map.get(airport).poll());
        }
        route.add(airport);
    }
}
*/