import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            // 종류별 빈도수 카운트 (없으면 0에서 시작해 +1)
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int kinds = freq.size();        // 서로 다른 종류 수
        int canPick = nums.length / 2;  // 가져갈 수 있는 수
        return Math.min(kinds, canPick);
    }
}