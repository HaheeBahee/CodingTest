import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String pName : participant){
            map.put(pName, map.getOrDefault(pName, 0) +1);
        }
        
        for(String cName : completion){
            map.replace(cName, map.get(cName) - 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0){ // 남은 선수가 완주 못한 선수
                answer = entry.getKey();
                break;
            }
        }
        
        
        
        
        return answer;
    }
}