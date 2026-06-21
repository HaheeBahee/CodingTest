/*
게시판 불량 이용자 신고, 처리 결과 메일 발송 
한 유저는 한 번에 한명의 유저만 신고.
신고 횟수 제한은 없으나 동일 유저에 대한 신고는 1회로 처리 
k 번 이상 신고된 유저는 게시판 이용 정지되고, 해당 유저 신고한 유저들에게 정지 사실을 이메일 발송

각 이용자별로 메일 받은 횟수 담아 반환 

HashMap + HashSet 맞음. 핵심은 “신고당한 사람 → 중복 제거된 신고자들” 구조를 만든 것.
*/

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String,Set<String>> reportedMap = new HashMap<>();
        
        
        for(int i = 0; i < report.length; i++){
            String[] arr = report[i].split(" ");
            String reporter = arr[0]; // 신고한 사람
            String target = arr[1];   // 신고당한 사람
            reportedMap.computeIfAbsent(target, key -> new HashSet<>())
               .add(reporter);
        }
        
        Map<String, Integer> mailCount = new HashMap<>();
        
        for(String target: reportedMap.keySet()){
            Set<String> reporters = reportedMap.get(target);
            
            if(reporters.size() >= k){
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        
        
        return answer;
    }
}