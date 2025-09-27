class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] answer = new int[len];

        for (long idx = left, k = 0; idx <= right; idx++, k++) {
            long row = idx / n; 
            long col = idx % n; 
            answer[(int)k] = (int)(Math.max(row, col) + 1);
        }
        return answer;
    }
}
