import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int h = n / w + 1;
        int[][] boxes = new int[h][w];
        
        int number = 0;
        for (int i = 0; i < h; i++) {
            if (i % 2 == 1)
                for (int j = w - 1; j >= 0; j--) {
                    boxes[i][j] = ++number;
                    if (number == n) break;
                }
            else 
                for (int j = 0; j < w; j++) {
                    boxes[i][j] = ++number;
                    if (number == n) break;
                }
			if (number == n) break;
        }
        
        int count = 0;
        int col = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (boxes[i][j] == num) col = j;
                if (j == col && boxes[i][j] != 0) count++;
            }
        }
        
        return count;
    }
}