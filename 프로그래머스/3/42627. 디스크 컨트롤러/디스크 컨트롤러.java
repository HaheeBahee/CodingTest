/*
하드디스크 1번에 1개 작업
우선순위 디스크 컨트롤러 : 
    1. 대기 큐 - 첨엔 비어있음. 요청 들어오면 작업번호,요청시각,소요시간 저장
    2. 하드디스크 작업 안함 + 대기큐에 작업 있음 -> 우선순위 높은꺼 꺼냄 
        - 소요시간 짧은것 - 요청 시각 빠른 것 - 작업 번호 작은 것
    3. 작업 다 할 때까지 안 멈춤
    4. 대기큐에 작업 있으면 바로바로 실행
입력 : [요청 시각, 소요 시간]
반환 : 모든 요청 반환 시간의 평균 정수부분

---
우선순위대로 꺼내야 하는 큐 -> 우선순위 큐
해당 시각을 기록하고, 해당 시각에 있는 작업들 중 소요 시간 짧은 것을 꺼낸다.
    만약 소요시각 같으면, 요청 시각 빠른 것 -> 요청 시각 같으면, 작업번호 작은 것
*/

import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a[1] != b[1]) return a[1] - b[1];
                if(a[0] != b[0]) return a[0] - b[0];
                return 0;   
            }
        );      
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        int currentTime = 0;
        int done = 0;
        int total = 0;
        int index = 0;
        
        while(done < jobs.length){
            while(index < jobs.length && jobs[index][0] <= currentTime){
                pq.offer(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()){
                int[] nowJob = pq.poll();
                currentTime += nowJob[1];
                total += currentTime - nowJob[0];

                done++;
            }else{
                currentTime = jobs[index][0];
            }
        }
        
        
        return total / jobs.length;
    }
}