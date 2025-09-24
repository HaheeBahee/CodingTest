import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String cur = words[i];

            boolean invalid =
                    cur.length() < 2 ||
                    used.contains(cur) ||
                    (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != cur.charAt(0));

            if (invalid) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[] { player, turn };
            }
            used.add(cur);
        }
        return new int[] { 0, 0 };
    }
}
