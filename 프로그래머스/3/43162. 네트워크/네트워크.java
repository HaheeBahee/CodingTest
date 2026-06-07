// 아웃 풋 : 네트워크 개수 
// 깊게 파서 연결된 뭉텅이 개수 -> DFS

// 한 네트워크에서 연결된거 쭉 모든 가능한 경로 다 갔 다 와. 

import java.util.*;

class Solution{
    int network =0;
    
    public int solution(int n, int[][] computers){
        // 방문 처리 해야함. 
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, computers);
                network++;
            }
        }
        return network;
                
    }
    
    public void dfs(int i, boolean[] visited, int[][] computers){
        visited[i] = true;
        
        for(int j = 0; j < visited.length; j++){
            if(computers[i][j] == 1 && !visited[j]){
                dfs(j, visited, computers);
            }
        }
        return;
        
    
        
    }       
}