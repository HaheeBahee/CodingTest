import java.util.*; 


class Solution {
    public int solution(String begin, String target, String[] words) {
        
        //초기 가지치기 - words에 target 없으면 0 반환 
        boolean hasTarget = false;
        for (String w : words) {
            if (w.equals(target)) { hasTarget = true; break; }
        }
        if (!hasTarget) return 0;
        
        //최소 단계 - bfs - 큐
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while (!queue.isEmpty()) { 
            Node cur = queue.poll();

            if (cur.word.equals(target)) return cur.depth;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && diffByOne(cur.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], cur.depth + 1));
                }
            }
        }
        return 0; // 변환 불가
    }
    
    //큐의 요소 형태 정의
    private static class Node{
        String word;
        int depth;
        Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    //한 글자만 다른지 체크
    private boolean diffByOne(String word1, String word2){
        int diff = 0;
        for(int i = 0; i <word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false; // 조기 종료
            }
        }
        return diff == 1;
    }
    
}