// 1번에 1개 바꿈, words에 있는 걸로만 변경가능
// 최단 변경 순서 -> BFS
// 해당 스트링과 요소 하나만 다른 걸 찾아야함.

import java.util.*;

class Solution{
    public static int solution(String begin, String target, String[] words){
        
        Queue<String[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new String[]{begin, "0"});
        
        while(!queue.isEmpty()){
            String[] curr = queue.poll();
            String word = curr[0];
            int dist = Integer.parseInt(curr[1]);
            
            if(word.equals(target)){
                return dist;
            }
            
            for(int i = 0; i < words.length; i++){
                int compare = 0;
                for(int j = 0; j < begin.length(); j++){
                    char c1 = word.charAt(j);
                    char c2 = words[i].charAt(j);
                    if(c1 != c2) compare++;
                }
                if(compare == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(new String[]{words[i], String.valueOf(dist + 1)});
                }
            }
            
            
        }
        return 0;
        
        
        
    }
}