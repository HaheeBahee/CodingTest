import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1; 
            int end   = commands[i][1];     
            int k     = commands[i][2];    

            int[] newArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(newArray);
            answer[i] = newArray[k - 1];
        }

        return answer;
    }
}
