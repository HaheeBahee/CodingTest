//3의 배수 or '3' 포함하면 스킵 -> 숫자 더 올림
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;

        while (count < n) {
            answer++; // 다음 후보
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                continue; // 금지면 카운트 안 하고 다음 루프로
            }
            count++; // 유효하면 카운트
        }
        return answer;
    }
}