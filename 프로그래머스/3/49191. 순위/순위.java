class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];

        for (int[] r : results) {
            int a = r[0], b = r[1];
            win[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (!win[i][k]) continue; 
                for (int j = 1; j <= n; j++) {
                    if (win[k][j]) win[i][j] = true;
                }
            }
        }


        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int wins = 0, losses = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (win[i][j]) wins++;
                if (win[j][i]) losses++;
            }
            if (wins + losses == n - 1) answer++;
        }
        return answer;
    }
}
