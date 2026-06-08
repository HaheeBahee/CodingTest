// 매일 다른 옷 조합(일부 겹쳐도 돼) , 종류별 최대 1가지 

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        // 카테고리 -> 키
        for(String[] item : clothes){
            map.put(item[1] , map.getOrDefault(item[1], 0) + 1);
        }
        
        int result = 1;
        for(int count : map.values()){
            result *= (count + 1);
        }
        
        return result - 1;
        
    }
}
