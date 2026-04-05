// 전체 예산 고정. 최대한 많은 부서 지원. => 적은 예산 순으로 정렬 => 버짓 이하 만큼 반복

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        int total = 0; 
        int count = 0;
        
        for(int i = 0; i < d.length ; i++){
            total += d[i];
            if(total <= budget){
                count++;
            }else{
                break;
            }
        }  
        return count;
    }
}