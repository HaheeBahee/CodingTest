//순서대로 아래서부터 쌓는다 (빵,야채,고기,빵 1,2,3,1)
//해시맵으로 넣을까...? 일단 무조건 1부터 시작해야하는데
//리스트로(값:개수) 개수 :4개 채워지면 끝

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]); // 재료 쌓기
            
            // 최근 4개가 [1,2,3,1]인지 확인
            if (list.size() >= 4) {
                int size = list.size();
                if (list.get(size-4) == 1 &&
                    list.get(size-3) == 2 &&
                    list.get(size-2) == 3 &&
                    list.get(size-1) == 1) {
                    
                    // 햄버거 완성 → 4개 제거
                    for (int j = 0; j < 4; j++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
