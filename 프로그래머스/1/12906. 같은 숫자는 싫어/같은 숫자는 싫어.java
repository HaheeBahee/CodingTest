//연속되는 숫자 하나만 남김 -> 직전 요소와 현재 요소와 비교  -> 스택 or 큐 
// -> 직전(마지막) 요소와 비교한다는 점에서 스택을 사용해야함. 큐는 맨앞만 확인가능
//제거 후 남은 요소들 반환시 순서 유지 -> 큐 -> 틀렸어
//반환 배열의 길이 모름 -> 리스트

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        Deque<Integer> compressedNumbers = new ArrayDeque<>();

        for (int currentNumber : arr) {
            // 마지막에 들어간 숫자와 현재 숫자가 다르면 추가
            if (compressedNumbers.isEmpty() || compressedNumbers.peekLast() != currentNumber) {
                compressedNumbers.addLast(currentNumber);
            }
        }

        int[] result = new int[compressedNumbers.size()];
        int resultIndex = 0;

        for (int number : compressedNumbers) {
            result[resultIndex++] = number;
        }

        return result;
    }
}

