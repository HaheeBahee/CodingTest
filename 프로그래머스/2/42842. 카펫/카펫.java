// brown : 갈색 격자 수, yellow : 노란색 격자 수
// 아웃풋 : [가로크기][세로크기]

// 공식 : 두 정수 곱해서 옐로우 되는 짝 a,b => (a+2)*(b+2) - yellow = brown 되는 거 찾기

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int a = i, b = yellow / i;
                if (a >= b && (a + 2) * (b + 2) - yellow == brown) {
                    return new int[]{a + 2, b + 2};
                }
            }
        }
        return new int[]{};
    }
}