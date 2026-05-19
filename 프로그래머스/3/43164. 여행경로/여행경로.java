// 항상 ICN 에서 시작, 주어진 항공권 모두 사용, 출발지 같은경우 도착지 알파벳 순서 앞에 있는 것
// 모든 항공권 사용 -> dfs
// 도착지 순서대로 정렬

import java.util.*;


class Solution {
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1])); // 정렬
        boolean[] visited = new boolean[tickets.length];        
        List<String> path = new ArrayList<>();
    
        path.add("ICN");
        dfs("ICN", path, visited, tickets);
    
        return path.toArray(new String[0]);  // List → String[] 변환
}
        

    
    
    boolean dfs(String now, List<String> path, boolean[] visited, String[][] tickets){        
        // 종료조건
        if(path.size() == tickets.length + 1) return true;

        
        for(int i = 0; i < tickets.length; i++){
            if(now.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                path.add(tickets[i][1]);
            
                if(dfs(tickets[i][1], path, visited, tickets)) return true; // true가 아래에서 위로 전파되면서 탐색이 즉시 멈춰.

                 // 백트래킹
                visited[i] = false;
                path.remove(path.size() - 1);

            }
        } return false;
    }
}