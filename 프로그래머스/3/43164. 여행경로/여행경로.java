// 항상 ICN 에서 시작, 주어진 항공권 모두 사용, 출발지 같은경우 도착지 알파벳 순서 앞에 있는 것
// 모든 항공권 사용 -> dfs
// 도착지 순서대로 정렬

import java.util.*;


class Solution {
    
    
    public String[] solution(String[][] tickets){
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        boolean[] visited = new boolean[tickets.length];
        List<String> 경로 = new ArrayList<>();
            
        String start = "ICN";
        경로.add("ICN");
        dfs(start, visited, 경로, tickets);
        return 경로.toArray(new String[0]);
    }
    
    public void dfs(String current, boolean[] visited, List<String> 경로, String[][] tickets){
    
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                경로.add(tickets[i][1]);
                dfs(tickets[i][1], visited, 경로, tickets);
                
            // 경로 완성됐으면 그냥 return
            if(경로.size() == tickets.length + 1) return;
            
            // 완성 안 됐으면 → 되돌리기
            visited[i] = false;
            경로.remove(경로.size() - 1);
            }
        } 
        
    }
}