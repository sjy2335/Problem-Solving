import java.util.*;

class Solution {
    
    private class Server {
        int time;
        int count;
        
        Server(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        
        int constructed = 0;
        
        Deque<Server> serverQueue = new ArrayDeque<>();
        
        for (int t = 0; t < players.length; t++) {
            
            if (!serverQueue.isEmpty() && serverQueue.peek().time + k == t) 
                serverQueue.poll();
            
            int servers = 0;
            for (Server s: serverQueue) servers += s.count;
            
            int serversRequired = players[t] / m;
            if (servers < serversRequired) {
                int newServers = serversRequired - servers;
                serverQueue.add(new Server(t, newServers));
                constructed += newServers;
            }
            
        }
        
        return constructed;
    }
}