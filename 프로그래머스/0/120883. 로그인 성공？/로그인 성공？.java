// 입력한 아이디와 패스워드 배열  - id_pw
// 회원들의 정보가 담긴 2차원 배열 - db
// 아이디와 비번 모두 일치하는 회원 있으면 login, 아이디 일치 없으면 fail, 아이디 일치하지만 비번 일치 없으면 wrong pw


class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        String id = id_pw[0];
        String pw = id_pw[1];
        
        for(int i = 0 ; i < db.length ; i++){
            if (id.equals(db[i][0])){
                if (pw.equals(db[i][1])){
                    return "login";
                }else{
                    return "wrong pw";
                }
            }
        }
        
        return "fail";
    }
}