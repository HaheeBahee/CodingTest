class Solution {
    public String solution(String X, String Y) {
        int[] cx = new int[10];
        int[] cy = new int[10];

        for (int i = 0; i < X.length(); i++) cx[X.charAt(i) - '0']++;
        for (int i = 0; i < Y.length(); i++) cy[Y.charAt(i) - '0']++;

        StringBuilder sb = new StringBuilder();
        
        for (int d = 9; d >= 0; d--) {
            int cnt = Math.min(cx[d], cy[d]);
            while (cnt-- > 0) sb.append((char)('0' + d));
        }

        if (sb.length() == 0) return "-1";    
        if (sb.charAt(0) == '0') return "0";   

        return sb.toString();
    }
}
