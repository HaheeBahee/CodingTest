// 자르기 -> 정렬 -> 찾기 

import java.util.*;

class Solution{
    public int[] solution(int[] array, int[][] commands){
        
        int[] result = new int[commands.length];
        
        
        for(int i = 0; i < commands.length; i++){
            // 자르기
            int[] cut = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            
            // 정렬
            Arrays.sort(cut);
            
            // 찾기
            result[i] = cut[commands[i][2] - 1];
        }
        return result;
    }
}