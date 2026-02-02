//진도 100%일때 배포. 각 기능의 개발속도 재각각. 앞 기능 배포시 완료된 뒤 기능들도 함께 배포 가능.
//입력 : 배포 순서대로 기능의 진도 적힌 정수 배열 progresses, 각 기능의 개발속도 적인 정수 배열 speeds
//출력 : 각 배포마다 배포되는 기능의 개수 배열 

/*
100% 되기까지 남은 진도 / 배포속도
맨앞의 요소와 같거나 작은 요소의 개수 출력
-> 맨앞 요소 기억, 같거나 작은요소 만나면 count
*/



import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList<>();
        
        int 기준일수 = remain(progresses[0], speeds[0]);
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            int 다음일수 = remain(progresses[i], speeds[i]);

            if (다음일수 <= 기준일수) {
                count++; // 같은 배포에 포함
            } else {
                result.add(count); // 이전 배포 확정
                기준일수 = 다음일수; // 기준 갱신
                count = 1; // 새 배포 시작
            }
        }

        result.add(count); // 마지막 배포 묶음 추가
        
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
     
   public int remain(int progress, int speed) {
        return (100 - progress + speed - 1) / speed; // 올림 정수 나눗셈
    }
}