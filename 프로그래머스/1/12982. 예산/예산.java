import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d); 
        int count = 0;
        int total = 0;

        for (int cost : d) {
            if (total + cost <= budget) { 
                total += cost;
                count++;
            } else { 
                break;
            }
        }
        return count;
    }
}