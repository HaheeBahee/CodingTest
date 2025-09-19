//귤
//HashMap<Integer, Integer>로 크기별 빈도수 집계
//빈도수들만 모아 내림차순 정렬
//큰 빈도부터 차감하며 k <= 0가 되는 순간의 사용한 종류 수가 정답
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int size : tangerine){
            freq.put(size, freq.getOrDefault(size,0)+1);
        }
        List<Integer> counts = new ArrayList<>(freq.values());
        counts.sort(Comparator.reverseOrder());
        
        int kinds = 0;
        for (int c : counts) {
            k -= c;
            kinds++;
            if (k <= 0) break;
        }
        return kinds;
    }
}