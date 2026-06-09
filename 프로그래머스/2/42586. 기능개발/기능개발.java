// 진도 100 - 배포 가능
// 앞의 기능이 다 되면 뒤의 진도 100인 애들도 같이 배포 가능

import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> time = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            time.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> result = new ArrayList<>();

        while (!time.isEmpty()) {
            int first = time.poll();
            int count = 1;
            while (!time.isEmpty() && time.peek() <= first) {
                time.poll();
                count++;
            }
            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}