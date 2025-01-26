import java.util.*;

class Solution {
    
    private class Job {
        int requestedTime, timeCost;

        public Job(int requestedTime, int timeCost) {
            this.requestedTime = requestedTime;
            this.timeCost = timeCost;
        }
    }
    
    public int solution(int[][] jobs) {
        // 작업을 요청 시각 순으로 정렬
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Job> pq = new PriorityQueue<>(
            (j1, j2) -> j1.timeCost != j2.timeCost ? Integer.compare(j1.timeCost, j2.timeCost)
                                                   : Integer.compare(j1.requestedTime, j2.requestedTime)
        );

        int timePassed = 0;
        int index = 0;
        int totalTurnaroundTime = 0;

        while (index < jobs.length || !pq.isEmpty()) {
            // 현재 시간까지 요청된 작업들을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= timePassed) {
                pq.add(new Job(jobs[index][0], jobs[index][1]));
                index++;
            }

            if (!pq.isEmpty()) {
                // 우선순위가 가장 높은 작업 처리
                Job currentJob = pq.poll();
                timePassed += currentJob.timeCost;
                totalTurnaroundTime += timePassed - currentJob.requestedTime;
            } else {
                // 대기 큐가 비어 있으면 시간을 다음 요청 시각으로 이동
                timePassed = jobs[index][0];
            }
        }

        // 반환 시간 평균 계산 후 정수 부분만 반환
        return totalTurnaroundTime / jobs.length;
    }
}