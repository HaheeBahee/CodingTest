import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if ((n & 1) == 1) return 0; 
        int ans = 0;
        String ss = s;

        for (int i = 0; i < n; i++) {
            if (isValid(ss)) ans++;
            ss = ss.substring(1) + ss.charAt(0);
        }
        return ans;
    }

    private boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (!match(top, c)) return false;
            }
        }
        return st.isEmpty();
    }

    private boolean match(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
}
