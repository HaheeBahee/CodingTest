class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) return 0; // 이미 같은 경우

        StringBuilder sb = new StringBuilder(A);

        for (int count = 1; count <= A.length(); count++) {
            // 마지막 문자 꺼내기
            char lastChar = sb.charAt(sb.length() - 1);
            // 마지막 문자 삭제
            sb.deleteCharAt(sb.length() - 1);
            // 맨 앞에 삽입
            sb.insert(0, lastChar);
            // 비교
            if (sb.toString().equals(B)) {
                return count; // 몇 번 밀어서 같아졌는지
            }
        }

        return -1; // 끝까지 해도 못 맞추면 -1
    }
}