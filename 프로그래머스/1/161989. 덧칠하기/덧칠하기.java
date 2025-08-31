class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int paintedEnd = 0;
        for (int pos : section) {
            if (pos > paintedEnd) {
                count++;
                paintedEnd = pos + m - 1;
            }        }
        return count;
    }
}
