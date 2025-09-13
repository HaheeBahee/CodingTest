//앞의 두개 숫자를 기억해야함
class Solution {
    public int solution(int n) {
    
        int[] arr = {0,1};
        int newN;
        
        for(int i = 2;  i <= n; i++){
            newN = (arr[0] + arr[1]) % 1234567;
            arr[0] = arr[1];
            arr[1] = newN;
        }        
        
        
        return arr[1];
    }
}