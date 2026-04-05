//t에서 p 길이와 같은 부분문자열 중에서, p보다 작거나 같은 수가 나오는 횟수
//오답노트 
//int는 길이 메서드 없음. Stirng은 길이 메서드 있음
//int의 범위 - 10자리 수, long의 범위 - 19자리 수

class Solution {
    public int solution(String t, String p) {
        
        int lenP = p.length();
        long intP = Long.parseLong(p);
        
        int result = 0;
        
        for(int i = 0 ; i + lenP - 1 < t.length() ; i++){
            long sub = Long.parseLong(t.substring(i,i + lenP));
            if(sub <= intP){
                result++;
            }
        }
        
        return result;
    }
}