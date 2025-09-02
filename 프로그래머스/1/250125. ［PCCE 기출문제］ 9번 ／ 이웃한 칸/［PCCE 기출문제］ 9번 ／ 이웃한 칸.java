class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;

        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        String target = board[h][w];

        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];

            if (0 <= nh && nh < n && 0 <= nw && nw < n) {
                if (target.equals(board[nh][nw])) count++;
            }
        }
        return count;
    }
}
