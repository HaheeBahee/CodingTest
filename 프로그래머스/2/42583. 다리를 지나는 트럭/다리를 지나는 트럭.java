import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        
        int time = 0;
        int onBridge = 0;

        for (int w : truck_weights) {
            while (true) {
                if (bridge.size() == bridge_length) {
                    
                    onBridge -= bridge.poll();
                    
                }

                if (onBridge + w <= weight) {
                    bridge.offer(w);
                    onBridge += w;
                    time++;
                    break;
                } else {
                    
                    bridge.offer(0);
                    time++;
                    
                }
            }
        }

        return time + bridge_length;
    }
}
