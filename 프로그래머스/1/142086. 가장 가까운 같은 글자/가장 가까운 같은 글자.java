//처음 나오면 -1
//가장 가까운 것과 인덱스 차이 구해서 거리 배열에 넣기 
class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];

        int index = 0; // 현재 문자의 인덱스
        for (char a : s.toCharArray()) { 
            answer[index] = -1;             // 기본값
            for (int i = index - 1; i >= 0; i--) {
                if (s.charAt(i) == a) {
                    answer[index] = index - i;
                    break;
                }
            }
            index++;
        }
        return answer;
    }
}