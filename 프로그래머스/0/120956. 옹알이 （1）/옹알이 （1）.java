//문자열 배열 중에서 조카가 발음할 수 있는 문자열의 개수 구하기
//포인트 : 4개의 문자열을 사용해서 어떻게든 이어붙여서 배열요소를 만들 수 있으면 돼.
//알고리즘 : replace를 통해 공백으로 대체해서 결과값이 공백으로 나오면 가능

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        
        
        for(String word : babbling){
            String canOrNot = word;
            int number = 0;
            for(String cS : canSpeak){
                canOrNot = canOrNot.replace(cS, "-");
            }
            if (canOrNot.replace("-","").equals("")){
                answer++;
            }
                
        }
       
        
        return answer;
    }
}