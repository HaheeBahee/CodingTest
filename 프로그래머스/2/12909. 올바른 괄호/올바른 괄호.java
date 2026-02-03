//1. 즉시 실패 조건 : 반드시 ) 개수는 (보다 크면 안된다. 
//2. 종료 조건 : (개수 = )개수
//괄호 종류 1개 -> balance 

class Solution {
    boolean solution(String s) {
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                balance++;
            } else { // ')'
                if (--balance < 0) return false; // 닫을 '('가 없음
            }
        }

        return balance == 0;
    }
}
