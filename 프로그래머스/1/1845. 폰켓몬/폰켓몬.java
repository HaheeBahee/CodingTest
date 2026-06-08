// 최대한 많은 종류 가져가기. N/2마리 가져가기(N은 짝수)
// 중복 있음 -> 해시, size로 종류

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int half = nums.length / 2;
        if(map.size() >= half){
            return half;
        }else{
            return map.size();
        }
    }
}
