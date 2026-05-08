//상대 팀 진영 먼저 파괴하기 - 최단거리 -> BFS
//흰 부분만 갈 수 있음. - 1부분만 접근 가능
//동서남북. 한칸씩 -> 선택지 4개
//상대 팀 진영 막혀있으면 아예 불가

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int startX = 0; // 시작 위치
        int startY = 0;
        
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY, 1});
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0], currentY = current[1]; // 현재 위치를 사용해서 다음 요소의 위치 알려고.
            int distance = current[2];

            if (currentX == maps.length - 1 && currentY == maps[0].length - 1) {
                return distance;
            }
            
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
                if(visited[nextX][nextY]) continue;
                if (maps[nextX][nextY] == 0) continue;
                
                visited[nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY, distance + 1});
            }
            
        }
        
        return -1;

    }
}