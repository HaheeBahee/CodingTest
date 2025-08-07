//반복문으로 문자열을 한자씩 순회
//첫글자를 x로 정함
//x의 횟수와 x가 아닌 글자의 횟수를 각각 셈
//두 횟수가 같아지면 분리 (count + 1)
//끝까지 순회하면 남은 문자열도 하나로 분리됨 

class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff =0;
        char x = s.charAt(0);
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(same == 0 && diff == 0){
                x = c;
            }
            if(x == c){
                same++;
            }else if (x != c){
                diff++;
            }
            
            if(same == diff){
                answer++;
                same = 0;
                diff = 0;
            }
        }
        if(same != 0 || diff != 0){
            answer++;
        }
        
        return answer;
    }
}