class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            
            int timeSet = schedules[i];
            int hourSet = timeSet / 100;
            int minSet = timeSet % 100;
            
            boolean valid = true;
            
            for (int j = 0; j < 7; j++) {
                
                if ((startday + j) % 7 == 6 || (startday + j) % 7 == 0) continue;
                
                int timeArrived = timelogs[i][j];
                int hourArrived = timeArrived / 100;
                int minArrived = timeArrived % 100;
                
                int timeDiff;
				if (hourArrived > hourSet) timeDiff = 60 * (hourArrived - hourSet - 1) + minArrived + 60 - minSet;
                else if (hourArrived == hourSet) timeDiff = minArrived - minSet;
                else timeDiff = 0;
                
                if (timeDiff > 10) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) answer++;
        }
        
        return answer;
    }
}