/*
자신보다 앞에 있으면서 가장 가까운 같은 글자의 위치
없으면 -1
존재했는지 유무와 위치를 기억해야하니까 Hashmap을 사용 
글자를 키 위치를 인덱스로 표시
*/

import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int[] result = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                result[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }else{ // 키 없으면 
                result[i] = -1;
            }
            map.put(s.charAt(i), i);

        }

        return result;
    }
}