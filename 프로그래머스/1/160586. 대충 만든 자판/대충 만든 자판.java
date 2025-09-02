import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minPress = new int[26];
        Arrays.fill(minPress, Integer.MAX_VALUE);

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'A';
                minPress[idx] = Math.min(minPress[idx], i + 1);
            }
        }


        int[] answer = new int[targets.length];
        for (int t = 0; t < targets.length; t++) {
            int sum = 0;
            boolean ok = true;
            for (int i = 0; i < targets[t].length(); i++) {
                int idx = targets[t].charAt(i) - 'A';
                if (minPress[idx] == Integer.MAX_VALUE) { 
                    ok = false;
                    break;
                }
                sum += minPress[idx];
            }
            answer[t] = ok ? sum : -1;
        }
        return answer;
    }
}
