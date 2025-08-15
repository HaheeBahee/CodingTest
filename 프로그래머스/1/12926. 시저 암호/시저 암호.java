class Solution {
    public String solution(String s, int n) {
        n %= 26; // 과도한 회전 방지
        StringBuilder sb = new StringBuilder(s.length());

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append(' ');
            } else if ('A' <= ch && ch <= 'Z') {
                sb.append((char) ('A' + (ch - 'A' + n) % 26));
            } else if ('a' <= ch && ch <= 'z') {
                sb.append((char) ('a' + (ch - 'a' + n) % 26));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}