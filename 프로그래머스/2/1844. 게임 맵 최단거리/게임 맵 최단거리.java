//상대 팀 진영 먼저 파괴하기 - 최단거리 -> BFS
//흰 부분만 갈 수 있음. - 1부분만 접근 가능
//동서남북. 한칸씩 -> 선택지 4개
//상대 팀 진영 막혀있으면 아예 불가

import java.util.*;

class Solution{
    public static int solution(int[][] maps){
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int[] start = {0,0,1};
        visited[start[0]][start[1]] = true;
        queue.offer(start);
        
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int startX = curr[0], startY = curr[1], dist = curr[2];
            
            // 도착지점
            if(startX == maps.length - 1 && startY == maps[0].length - 1){
                return dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = startX + dx[i], nextY = startY + dy[i];                
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
                if(maps[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY, dist + 1});
            }
        } 
        
        return -1;
        
        
        
        
    }
}