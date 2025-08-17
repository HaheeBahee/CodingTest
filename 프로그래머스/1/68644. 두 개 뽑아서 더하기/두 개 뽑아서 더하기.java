import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) { // i < j
                sums.add(numbers[i] + numbers[j]);
            }
        }

        // Set -> 정렬된 배열
        int[] answer = sums.stream()
                           .mapToInt(Integer::intValue)
                           .sorted()
                           .toArray();
        return answer;
    }
}