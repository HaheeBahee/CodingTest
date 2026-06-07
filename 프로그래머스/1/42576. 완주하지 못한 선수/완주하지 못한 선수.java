// 한 명 빼고 모두 완주
// 인풋 : 참여 선수 이름, 완주 선수 이름
// 아웃풋 : 완주 못한 선수 이름
// 주의 : 동명이인 있음

// 참여 선수 배열 - 완주 선수 

import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String person : participant){
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        for(int i = 0; i < completion.length; i++){
            if (map.get(completion[i]) == 1) {
                map.remove(completion[i]);
            } else {
                map.put(completion[i], map.get(completion[i]) - 1); 
            }
        }
        return map.keySet().iterator().next();
    }
}