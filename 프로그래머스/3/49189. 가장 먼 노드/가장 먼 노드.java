import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //인접 리스트
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : edge) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }

        //거리 배열
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        //BFS - 큐
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.offer(nxt);
            }
        }

        //노드 수 세기
        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, dist[i]);

        int count = 0;
        for (int i = 1; i <= n; i++) if (dist[i] == max) count++;

        return count;
    }
}
