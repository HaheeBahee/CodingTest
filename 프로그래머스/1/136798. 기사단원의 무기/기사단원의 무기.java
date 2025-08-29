class Solution {
    public int solution(int number, int limit, int power) {
        int[] cnt = new int[number + 1];

        for (int d = 1; d <= number; d++) {
            for (int m = d; m <= number; m += d) {
                cnt[m]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int atk = cnt[i] > limit ? power : cnt[i];
            answer += atk;
        }
        return answer;
    }
}
