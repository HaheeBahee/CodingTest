import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> cntByType = new HashMap<>();
        
        for (String[] item : clothes) {
            String type = item[1];
            cntByType.put(type, cntByType.getOrDefault(type, 0) + 1);
        }
        
        int ways = 1;
        for (int cnt : cntByType.values()) {
            ways *= (cnt + 1);
        }
        return ways - 1; 
    }
}
