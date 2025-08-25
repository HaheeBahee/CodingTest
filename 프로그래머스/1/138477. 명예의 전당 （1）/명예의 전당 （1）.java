import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] answer = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(score[i]);          
            if (pq.size() > k) pq.poll(); 
            answer[i] = pq.peek();      
        }
        return answer;
    }
}