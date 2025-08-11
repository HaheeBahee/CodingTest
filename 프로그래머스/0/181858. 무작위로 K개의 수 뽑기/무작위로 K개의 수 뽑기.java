import java.util.Arrays; 
//앞에서부터 서로 다른 k개의 수를 골라낸다
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int count = 0;

        for (int i = 0; i < arr.length && count < k; i++) {
            boolean sameOrNot = false;
            for (int j = 0; j < count; j++) { // 이미 채운 구간까지만 확인
                if (arr[i] == answer[j]) {
                    sameOrNot = true;
                    break;
                }
            }
            if (!sameOrNot) {
                answer[count] = arr[i];
                count++;
            }
        }
        return answer;
    }
}