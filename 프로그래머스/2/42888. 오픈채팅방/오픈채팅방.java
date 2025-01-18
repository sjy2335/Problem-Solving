import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    private static final Map<String, String> messageMap = new HashMap<>();
    
    static {
        messageMap.put("Enter", "님이 들어왔습니다.");
        messageMap.put("Leave", "님이 나갔습니다.");
    }
    
    public String[] solution(String[] record) {
        Deque<String> answer = new ArrayDeque<>();
        Map<String, String> uidNameMap  = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] commands = record[i].split(" ");
            if (commands[0].equals("Enter")) {
                uidNameMap.put(commands[1], commands[2]);
            }
            if (commands[0].equals("Change")) {
                uidNameMap.put(commands[1], commands[2]);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
			String[] commands = record[i].split(" ");
            if (commands[0].equals("Change")) continue;
            String name = uidNameMap.get(commands[1]);
            answer.addLast(name + messageMap.get(commands[0]));
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}