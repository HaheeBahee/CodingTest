class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int q = n / a;          // 이번에 교환 가능한 횟수
            int exchanged = q * b;  // 이번에 받는 콜라 수
            answer += exchanged;    // 누적
            n = exchanged + (n % a);// 마신 후 생긴 빈병 + 남은 빈병
        }

        return answer;
    }
}