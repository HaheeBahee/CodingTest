class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] has = new int[n + 2]; 
       
        for (int i = 1; i <= n; i++) has[i] = 1;

     
        for (int l : lost) has[l]--;
        for (int r : reserve) has[r]++;

        for (int i = 1; i <= n; i++) {
            if (has[i] == 0) {
                if (has[i - 1] == 2) {
                    has[i - 1]--;
                    has[i]++;
                } else if (has[i + 1] == 2) {
                    has[i + 1]--;
                    has[i]++;
                }
            }
        }

        
        int answer = 0;
        for (int i = 1; i <= n; i++) if (has[i] >= 1) answer++;
        return answer;
    }
}
