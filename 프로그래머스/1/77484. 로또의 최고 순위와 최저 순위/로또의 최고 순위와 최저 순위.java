import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
        
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }
        
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matchCount++;
            }
        }
        
        int maxMatch = matchCount + zeroCount;
        int minMatch = matchCount;
        
        return new int[] {getRank(maxMatch), getRank(minMatch)};
    }
    
    private int getRank(int match) {
        if (match < 2) return 6;
        return 7 - match;
    }
}
