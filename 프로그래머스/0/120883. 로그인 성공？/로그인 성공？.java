
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        boolean idCorrect = false;
        boolean pwCorrect = false; //비밀번호 맞는지 아닌지
        
        for(int i = 0; i < db.length; i++){
            //id가 같은지 확인
            if(id_pw[0].equals(db[i][0])){
                //id가 같으면, password가 같음
                if(id_pw[1].equals(db[i][1])){
                    answer ="login";
                    pwCorrect = true; // 비밀번호도 맞음
                    break; // 더 볼 필요 없음
                }else {//password가 다름
                    idCorrect = true;
                    pwCorrect = false; 
                }
            }
        }
         if (idCorrect && !pwCorrect) {
            answer = "wrong pw";
        } else if (!idCorrect && !pwCorrect) {
            answer = "fail";
        }
        
        
        return answer;
    }
}