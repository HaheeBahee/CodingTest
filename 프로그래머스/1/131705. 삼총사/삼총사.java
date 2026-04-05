// 세 정수 합했을 때 0 => 삼총사
// 삼총사 만들 수 있는 여러가지 조합


class Solution {
    public int solution(int[] number) {
        
        int result = 0;
        
        for(int i = 0 ; i + 2 < number.length; i++){
            for(int j = i + 1; j + 1 < number.length; j++){
                for(int k = j + 1 ; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        result++;
                    }
                }
            }
        }
    

        return result;
    }
}