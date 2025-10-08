import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); 
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int order = 0; 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curPriority = current[1];

            boolean hasHigher = false;
            for (int[] process : queue) {
                if (process[1] > curPriority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current);
            } else {
                order++;
                if (current[0] == location) {
                    return order;
                }
            }
        }

        return order;
    }
}
