class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0; // 단어 내 위치

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {   // 공백일 때
                sb.append(c);
                index = 0;   // 단어 인덱스 초기화
            } else {              
                if (index % 2 == 0) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
                index++;
            }
        }

        return sb.toString();
    }
}
