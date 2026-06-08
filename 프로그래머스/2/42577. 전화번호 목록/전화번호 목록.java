// A 번호가 B 번호의 접두어 => false

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String pre : phone_book){
            map.put(pre, 1);
        }
        
        for(String number : phone_book){
            for(int i = 0; i < number.length(); i++){
                String sub = number.substring(0, i);
                if(map.containsKey(sub)) return false;
            }
        }
        return true;
    }
}