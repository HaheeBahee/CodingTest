import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(char a : s.toCharArray()){
            if(a == '(') stack.push(a);
            else{
                if(stack.isEmpty()){
                return false; 
                }else{
                    stack.pop();
                }
            } 
                
                
        }

        return stack.isEmpty();
    }
}