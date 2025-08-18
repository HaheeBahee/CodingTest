//진도가 100%
//뒤 친구 완료되면 앞친구 완료될때 같이 배포
//배포순서 배열, 개발속도 배열

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