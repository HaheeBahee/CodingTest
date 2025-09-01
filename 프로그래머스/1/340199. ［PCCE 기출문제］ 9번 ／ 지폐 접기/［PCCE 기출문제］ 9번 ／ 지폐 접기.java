class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);
        int b0 = bill[0], b1 = bill[1];

        while (true) {
            int bMin = Math.min(b0, b1);
            int bMax = Math.max(b0, b1);

            if (bMin <= wMin && bMax <= wMax) break;

            if (b0 >= b1) b0 /= 2;
            else b1 /= 2;

            answer++;
        }

        return answer;
    }
}
