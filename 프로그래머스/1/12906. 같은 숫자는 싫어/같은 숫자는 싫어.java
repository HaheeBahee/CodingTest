// 배열에서 연속하는 숫자 하나만 남기기
// 반환 시 순서 유지

import java.util.*;

public class Solution{
    public int[] solution(int[] arr){

        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1])continue;
            list.add(arr[i]);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}