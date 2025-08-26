//영어 단어 뭉치 2개 
//카드를 순서대로 한장씩 사용
//한번 사용하면 다시 못함
//카드는 무조건 사용해야함
//기존의 단어 순서 바꿀 수 없음 

//아이디어 
//골 맨 앞 문자열 가져와서 카드1,카드2 맨 앞에 있는지 확인해서 가져오고, 해당 카드 뭉치의 인덱스 올리기
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int c1Idx = 0;
        int c2Idx = 0;
        boolean can = false;
        
        
        for(int i = 0; i< goal.length; i++){
            String goalFirst = goal[i];
            if (c1Idx < cards1.length && cards1[c1Idx].equals(goalFirst)) {
                can = true;
                c1Idx++;
            }
            else if (c2Idx < cards2.length && cards2[c2Idx].equals(goalFirst)) {
                can = true;
                c2Idx++;
            }
            else {
                can = false;
                break;
            }
        }
        
        
        
        
        return can ? "Yes" : "No";
    }
}