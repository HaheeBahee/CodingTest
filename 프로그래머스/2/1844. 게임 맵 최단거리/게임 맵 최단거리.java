//상대 팀 진영 먼저 파괴하기 - 최단거리 -> BFS
//흰 부분만 갈 수 있음. - 1부분만 접근 가능
//동서남북. 한칸씩 -> 선택지 4개
//상대 팀 진영 막혀있으면 아예 불가

import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;

        // 시작이나 도착이 벽인 경우 
        if (maps[0][0] == 0 || maps[n-1][m-1] == 0) return -1;

        int[][] dist = new int[n][m]; // 0은 미방문, 양수: 거리
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

        
            if (r == n - 1 && c == m - 1) return dist[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];

               
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (maps[nr][nc] == 0 || dist[nr][nc] != 0) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
   
        return -1;
    }
}