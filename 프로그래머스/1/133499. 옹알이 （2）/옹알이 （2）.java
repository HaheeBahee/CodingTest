//가능한 스트링은 정해져 있음. 각 하나씩 뭉텅이로 떨어지면 안돼.
//경우의 수를 미리 만드는 건 너무 공간 낭비
//배딩에서 한글자씩 받아오고 가능한 스트링과 같은지 매번 확인할까?

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = new String[]{"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            StringBuilder checkWord = new StringBuilder();
            String lastMatch = "";       
            boolean valid = true;      
            
            for(char c : babbling[i].toCharArray()){
                checkWord.append(c);
                for(String string : canSpeak){
                    if(string.equals(checkWord.toString())){
                        if(string.equals(lastMatch)){  
                            valid = false;
                            break;
                        }
                        lastMatch = string;           
                        checkWord.setLength(0);      
                    }
                }
                if(!valid) break; 
            }
            
            if(valid && checkWord.length()==0){  
                answer++;
            }
        }
        return answer;
    }
}