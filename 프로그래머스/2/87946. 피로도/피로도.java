class Solution {
    private int max = 0;
    private boolean[] used;

    public int solution(int k, int[][] dungeons) {
        used = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }

    private void dfs(int fatigue, int[][] dgs, int count) {
        if (count > max) max = count;

        for (int i = 0; i < dgs.length; i++) {
            if (used[i]) continue;

            int need = dgs[i][0];
            int cost = dgs[i][1];

            if (fatigue >= need) {
                used[i] = true;
                dfs(fatigue - cost, dgs, count + 1);
                used[i] = false; 
            }
        }
    }
}
