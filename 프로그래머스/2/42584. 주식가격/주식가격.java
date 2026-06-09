import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = (prices.length - 1) - idx;
        }

        return result;
    }
}