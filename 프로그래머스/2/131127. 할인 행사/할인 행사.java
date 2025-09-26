import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int n = discount.length;
        int window = 10;
        if (n < window) return 0;

        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }

        Map<String, Integer> have = new HashMap<>();

        for (int i = 0; i < window; i++) {
            have.merge(discount[i], 1, Integer::sum);
        }

        int answer = 0;
        if (matches(have, need)) answer++;

        for (int i = window; i < n; i++) {
            String out = discount[i - window];       
            String in  = discount[i];              
            have.put(out, have.get(out) - 1);
            if (have.get(out) == 0) have.remove(out);

            have.merge(in, 1, Integer::sum);

            if (matches(have, need)) answer++;
        }

        return answer;
    }

    private boolean matches(Map<String, Integer> have, Map<String, Integer> need) {
        for (Map.Entry<String, Integer> e : need.entrySet()) {
            if (!have.getOrDefault(e.getKey(), 0).equals(e.getValue())) {
                return false;
            }
        }

        return true;
    }
}
