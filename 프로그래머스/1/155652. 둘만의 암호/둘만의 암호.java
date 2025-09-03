class Solution {
    public String solution(String s, String skip, int index) {
        
        boolean[] banned = new boolean[26];
        for (char ch : skip.toCharArray()) {
            banned[ch - 'a'] = true;
        }

        StringBuilder ring = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (!banned[i]) ring.append((char) ('a' + i));
        }
        String allowed = ring.toString();
        int L = allowed.length();

       
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            int pos = allowed.indexOf(c);          
            int nextPos = (pos + index) % L;          
            ans.append(allowed.charAt(nextPos));
        }
        return ans.toString();
    }
}
