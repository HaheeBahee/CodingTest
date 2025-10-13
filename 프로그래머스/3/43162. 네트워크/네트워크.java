class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networks = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                networks++;
            }
        }
        return networks;
    }

    private void dfs(int cur, int n, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        for (int next = 0; next < n; next++) {
            if (next != cur && computers[cur][next] == 1 && !visited[next]) {
                dfs(next, n, computers, visited);
            }
        }
    }
}
