// 연속적으로 나타내는 숫자 하나만 남기고 제거 , 기본 순서는 유지해야함
// 직전 요소와 현재 요소만 비교하면 되므로 Stack 사용, 꺼낼때 뒤에서부터 채워야함. 

// 리팩토링 팁 : Stack 대신 List 사용하면 역순 복원 불필요
//              → answer.get(answer.size() - 1) 로 직전 요소 바로 비교 가능
//              → 코드가 더 단순해지므로 실전에서는 List 권장

import java.util.*;

public class Solution {
    public int[] solution(int[] inputArr) {

        // 결과를 담을 리스트 (크기를 모르니까 List 사용)
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < inputArr.length; i++) {
            int current = inputArr[i];

            // 리스트가 비어있거나, 마지막 요소와 현재 요소가 다를 때만 추가
            // (int) 캐스팅으로 Integer → int 언박싱 후 비교
            if (answer.isEmpty() || (int) answer.get(answer.size() - 1) != current) {
                answer.add(current);
            }
        }

        // List<Integer> → int[] 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}

