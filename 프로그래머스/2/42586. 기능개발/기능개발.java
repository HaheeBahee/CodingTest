//진도 100%일때 배포. 각 기능의 개발속도 재각각. 앞 기능 배포시 완료된 뒤 기능들도 함께 배포 가능.
//입력 : 배포 순서대로 기능의 진도 적힌 정수 배열 progresses, 각 기능의 개발속도 적인 정수 배열 speeds
//출력 : 각 배포마다 배포되는 기능의 개수 배열 

/*
100% 되기까지 남은 진도 / 배포속도
맨앞의 요소와 같거나 작은 요소의 개수 출력

*/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.offer(day);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            int current = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.poll();
                count++;
            }
            
            result.add(count); 
                
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
        
    }
}