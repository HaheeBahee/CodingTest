//입력 정수들을 사용 + 순서 바뀜 X + 빼기/더하기를 이용해 특정 넘버를 만든다.
//특정 넘버를 만들 수 있는 방법의 수를 리턴
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        
        int h = numbers.length;
        
        while(!stack.isEmpty()){
            int[] next = stack.pop();
            int index = next[0];
            int sum = next[1];
            
            if(index == h){
                if(sum == target) answer ++;
                continue;
            }
            
            stack.push(new int[]{index + 1, sum - numbers[index]}); // - 선택
            stack.push(new int[]{index + 1, sum + numbers[index]}); //+ 선택
            
        }
        
        return answer;
    }
}