//요소 하나를 기준점으로 잡고, 같은 x절편 요소와 같은 y절편 요소를 찾아서 절대값 차이로 변수 길이 구하기

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = dots[0][0];
        int y = dots[0][1];
        int lengthX = 0;
        int lengthY = 0;
        
        for(int i = 1 ; i < dots.length ; i++){
            if(dots[i][0] == x){
                lengthY = Math.abs(y - dots[i][1]);
            }else if (dots[i][1] == y){
                lengthX = Math.abs(x - dots[i][0]);
            }
        }
        
        answer = lengthX * lengthY;
        
        return answer;
    }
}