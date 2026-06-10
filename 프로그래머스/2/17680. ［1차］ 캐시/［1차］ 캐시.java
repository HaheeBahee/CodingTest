// 데이터 베이스에서 게시물 가져오는 실행시간 오래 걸림 -> DB 캐시 적용
// 캐시 크기에 따른 실행시간 측정 프로그램

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
       
        if (cacheSize == 0) return cities.length * 5;

        // LRU 캐시 생성
        // accessOrder=true → get/put 시 해당 항목 맨 뒤로 이동
        // removeEldestEntry → size 초과 시 맨 앞(가장 오래된) 항목 자동 제거
        LinkedHashMap<String, Integer> cache
                = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > cacheSize;
            }
        };

        int runtime = 0;

        for (String c : cities) {
            String city = c.toLowerCase();

            if (cache.containsKey(city)) {
                runtime += 1;
            } else {
                runtime += 5;
            }
            cache.put(city, 1);
        }
        return runtime;
    }
}