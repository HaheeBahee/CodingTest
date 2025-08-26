//사진별 추억점수
//사진 속 인물들의 그리움 합산 => 각 사진의 추억점수
//배열의 각 요소를 확인
//하나의 배열을 기준으로 그 요소들이 다른 배열에 있는지 확인
//이름과 해당 그림움을 맵으로 만들자.
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        
        HashMap<String,Integer> nameValue = new HashMap<>();
        for(int i = 0; i< name.length; i++){
            nameValue.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        
        //각 포토 확인
        for(int i = 0; i < photo.length; i++){
            int total = 0;
            for(int j=0; j < photo[i].length; j++){
                total += nameValue.getOrDefault(photo[i][j],0);
            }
            result[i] = total;
        }
        
        
        return result;
    }
}