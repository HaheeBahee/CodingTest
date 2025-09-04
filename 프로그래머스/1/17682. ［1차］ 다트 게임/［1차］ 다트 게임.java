class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);

            if (Character.isDigit(ch)) {               
                int num = ch - '0';
                if (ch == '1' && i + 1 < dartResult.length()
                        && dartResult.charAt(i + 1) == '0') {  
                    num = 10;
                    i++;
                }
                scores[++idx] = num;
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {  
                int pow = (ch == 'S') ? 1 : (ch == 'D') ? 2 : 3;
                scores[idx] = (int) Math.pow(scores[idx], pow);
            } else if (ch == '*') {                           
                scores[idx] *= 2;
                if (idx > 0) scores[idx - 1] *= 2;
            } else if (ch == '#') {                            
                scores[idx] *= -1;
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}
