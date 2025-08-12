class Solution {
    public int[][] solution(int[][] arr) {
        
        int rNum = arr.length;
        int cNum = arr[0].length;
        
        int size = Math.max(rNum, cNum);
        int[][] answer = new int[size][size];   
        
       for (int i = 0; i < rNum; i++) {
            for (int j = 0; j < cNum; j++) {
                answer[i][j] = arr[i][j];
            }
        }

        return answer;
    }
}