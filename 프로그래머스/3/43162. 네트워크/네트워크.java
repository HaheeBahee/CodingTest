import java.util.*;

class Solution{
    public int solution(int computerNumber, int[][] computers){
        
        int network = 0;
        boolean[] visited = new boolean[computerNumber];
        
        
        for(int i = 0; i < computerNumber; i++){
            if(!visited[i]){
                BFS(i, visited, computerNumber, computers);
                network++;
            }
        } return network;
    }
    
    void BFS(int start, boolean[] visited, int computerNumber, int[][] computers){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0 ; i < computerNumber; i++){
                if(!visited[i] && computers[curr][i] == 1){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        
    }
    
    
}