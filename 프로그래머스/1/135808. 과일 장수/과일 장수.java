
//상태에 따라 1-k까지 분류
//한 상자 가격 : 가장 낮은 점수 p * m
//가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익
//상자 단위로만 판매, 나머지는 버림
//그럼 제일 큰수부터 차례대로 담아야겠네
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] count = new int[k]; 


        for (int i = 0; i < score.length; i++) {
            count[score[i] - 1]++; 
        }

        int index = k - 1; 
        int acc = 0;       

        while (index >= 0) { 
            acc += count[index];
            while (acc >= m) { 
                answer += (index + 1) * m; 
                acc -= m;
            }
            index--;
        }

        return answer;
    }
}
