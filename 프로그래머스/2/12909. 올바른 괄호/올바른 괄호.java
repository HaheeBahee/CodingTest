// 1. ( 만나면 스택에 넣기
// 2. ) 만나면 스택에서 꺼내기
// 스택에서 꺼낼 거 없으면 false
// 마지막에 스택에 요소 남아있으면 false

// "괄호의 개수 균형" 만 알면 되기 때문에 stack 쓰는건 과하긴 해.

import java.util.*;

class Solution {
    
    boolean solution(String s){
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
       return stack.isEmpty();
    }
}