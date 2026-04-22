// 입력한 방향키 배열 - keyinput
// 맵의 크기 (맵의 크기를 넘어갈 순 없음) - board
// 조건 - 시작은 [0,0], (맵의 길이-1)/2 를 넘어설 수 없음.

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int limitW = (board[0] - 1) / 2;
        int limitH = (board[1] - 1) / 2; 
        
        for(int i = 0 ; i < keyinput.length; i++){
            String next = keyinput[i];
            
            if (next.equals("left") && answer[0] > -limitW){
                answer[0] -= 1;
            }else if ( next.equals("right") && answer[0] < limitW){
                answer[0] += 1;
            }else if (next.equals("down") && answer[1] > -limitH){
                answer[1] -= 1;
            }else if (next.equals("up") && answer[1] < limitH){
                answer[1] += 1;
            }
        }
        return answer;
    }
}