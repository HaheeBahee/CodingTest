class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 26개 알파벳 매핑 (-1이면 skill에 없음)
        int[] order = new int[26];
        for (int i = 0; i < 26; i++) order[i] = -1;
        for (int i = 0; i < skill.length(); i++) {
            order[skill.charAt(i) - 'A'] = i;
        }

        for (String tree : skill_trees) {
            int nextOrder = 0;
            boolean ok = true;

            for (int i = 0; i < tree.length(); i++) {
                int value = order[tree.charAt(i) - 'A'];
                if (value == -1) continue;      // 스킬 순서에 없는 건 무시
                if (value == nextOrder) nextOrder++;      // 기대한 스킬이면 통과
                else { ok = false; break; }   // 순서 어김
            }

            if (ok) answer++;
        }

        return answer;
    }
}