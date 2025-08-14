//인덱스 번호와 해당 영단어가 같음
class Solution {
    public int solution(String s) {
        String[] words = {
            "zero","one","two","three","four",
            "five","six","seven","eight","nine"
        };

        for (int d = 0; d <= 9; d++) {
            s = s.replace(words[d], String.valueOf(d));
        }

        return Integer.parseInt(s);
    }
}