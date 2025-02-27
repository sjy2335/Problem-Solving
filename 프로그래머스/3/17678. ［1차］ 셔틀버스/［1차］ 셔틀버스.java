import java.util.*;

class Solution {
    private class Time {
        int hour, minute;
        
        Time(String time) {
            String[] splitted = time.split(":");
            this.hour = Integer.parseInt(splitted[0]);
            this.minute = Integer.parseInt(splitted[1]);
        }
        
        void addMinutes(int minutes) {
            this.minute += minutes;
            
            if (minute >= 60) {
                this.minute -= 60;
                this.hour++;
            }
            
            if (minute < 0) {
                this.minute = 60 + this.minute;
                this.hour--;
            }
            
        }
        
        boolean isLaterThan(Time o) {
            if (this.hour > o.hour) return true;
            if (this.hour < o.hour) return false;
            if (this.minute > o.minute) return true;
            return false;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            
            if (this.hour < 10) sb.append("0");
            sb.append(this.hour).append(":");
            if (this.minute < 10) sb.append("0");
            sb.append(this.minute);
            
            return sb.toString();
        }
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        
        Arrays.sort(timetable);
        int total = timetable.length;
        
        Time[] times = new Time[total];
        for (int i = 0; i < total; i++) {
            times[i] = new Time(timetable[i]);
        }
        
        Time bus = new Time("09:00");
        int nextCrew = 0;
        Time result = new Time("00:00");
        
        for (int i = 0; i < n; i++) {
            
            if (nextCrew >= total) {
                result = new Time(bus.toString());
                bus.addMinutes(t);
                continue;
            }

            int j;
            Time maxCrewTime = times[nextCrew];
            
            for (j = 0; j < m && nextCrew < total; j++) {
                if (times[nextCrew].isLaterThan(bus)) break;
                maxCrewTime = times[nextCrew++];
            }
            
            if (j < m) result = new Time(bus.toString());
            else {
                result = new Time(maxCrewTime.toString());
                result.addMinutes(-1);
            }
            
            bus.addMinutes(t);
            
        }
        
        return result.toString();
    }
}