import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    private static final HashMap<Character, int[]> directions = new HashMap<>();
    
    private static void initDirections() {
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('R', new int[]{1, 0});
        directions.put('L', new int[]{-1, 0});
    }
    
    private static boolean isValidPoint(int nx, int ny) {
        return nx >= -5 && ny >= -5 && nx <= 5 && ny <= 5;
    }
    
    public int solution(String dirs) {
        initDirections();
        
		HashSet<String> set = new HashSet<>();
        
        int x = 0, y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char newDirection = dirs.charAt(i);
            int dx = directions.get(newDirection)[0];
            int dy = directions.get(newDirection)[1];
            
            int nx = x + dx;
            int ny = y + dy;
            
			if (isValidPoint(nx, ny)) {
                set.add(x + " " + y + " " + nx + " " + ny);
                set.add(nx + " " + ny + " " + x + " " + y);
                x = nx;
                y = ny;
            }
        }
        
        return set.size() / 2;
    }
}