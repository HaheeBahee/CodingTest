import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameras = 0;
        int cameraPos = Integer.MIN_VALUE;
        
        for (int[] r : routes) {
            int entry = r[0];
            int exit  = r[1];
            if (entry > cameraPos) {  
                cameraPos = exit;
                cameras++;
            }
        }
        return cameras;
    }
}
