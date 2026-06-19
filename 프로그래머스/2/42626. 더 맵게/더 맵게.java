/*
모든 음식의 스코빌 지수 >= k 
=> 가장 낮은 2개 음식을 섞어 새로운 음식 안든다.
- 만약 모든 음식 k이상 안되면 -1 

---
배열에서 가장 낮은 애들을 찾아야 하는데 하나하나 비교하는건 이중 포문 X -> PriorityQueue 사용
두개씩 합쳐서 마지막 하나가 남았는데 k보다 작으면 -1
*/

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        
        int count = 0;
        while(pq.size() > 1 && pq.peek() < K){
            int firstSmall = pq.poll();
            int secondSmall = pq.poll();
            int newElement = firstSmall + (secondSmall * 2);
            
            pq.offer(newElement);
            count++;
        }
        
        if (pq.peek() >= K) {
            return count;
        }
        
        return -1;
    }
}