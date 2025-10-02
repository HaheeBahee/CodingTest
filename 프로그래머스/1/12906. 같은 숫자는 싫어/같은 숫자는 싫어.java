//연속적인 숫자는 하나만 남기고 제거
//순서 유지 

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(arr[0]); 

        for (int i = 1; i < arr.length; i++) {
            
            //Rear 확인
            if (arr[i] != deque.peekLast()) {
                deque.add(arr[i]);
            }
        }

        // Deque → int[]
        int[] answer = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            answer[i++] = deque.pollFirst(); 
        }

        return answer;
    }
}
