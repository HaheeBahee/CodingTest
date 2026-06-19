//가로>=세로 되도록 회전

import java.util.*;

class Solution {
    public int solution(int[][] sizes){
        // 각 명함 가로 >= 세로 되도록 회전 
        for(int[] size : sizes){
            if(size[0] < size[1]){
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
        }
        // 가로 길이에서 맥스 찾기
        int 가로max = 1;
        int 세로max = 1;
        for(int i = 0 ; i < sizes.length ; i++){
            if(sizes[i][0] > 가로max){
                가로max = sizes[i][0];
            }
            if(sizes[i][1] > 세로max){
                세로max = sizes[i][1];
            }
        }
        return 가로max * 세로max;
    }
}