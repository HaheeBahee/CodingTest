// 인풋 : 게임판, 포크레인 이동경로
// 아웃풋 : 사라진 인형 개수 - 같은 숫자 2개가 만나면 사라짐

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int count = 0; // 터진 인형 개수
        
        Deque<Integer> stack = new ArrayDeque(); // 바구니 역할 스택
        
        // moves 배열을 순서대로 처리
        for(int i = 0; i < moves.length; i++){
            
            // moves -1 을 해줘야 보드 인덱스와 맞음
            int moveCol = moves[i] - 1;
            Boolean isItDoll = false;
            
            // 해당 열(col)에서 위에서부터 내려가며 인형(≠0) 찾기
            for(int row = 0; row < board.length; row++){
                
                // 인형 없으면 다음 행으로 넘어가서 다시 인형 있는지 없는지 확인해야 하기 때문에 row++ 가 아니라 continue
                if(board[row][moveCol] == 0) {
                    continue;
                } else { // 인형 찾으면
                    int findDoll = board[row][moveCol];
                    if(stack.isEmpty()){
                        stack.push(findDoll);
                        board[row][moveCol] = 0;
                    }else{
                        // 스택 상단 인형과 찾은 인형 비교
                        if(findDoll == stack.peek()){
                            count += 2;
                            board[row][moveCol] = 0;
                            stack.pop();
                        }else{
                            stack.push(findDoll);
                            board[row][moveCol] = 0;
                        }
                    }
                    break; 
                }
            }
        }
        return count;
    }
}