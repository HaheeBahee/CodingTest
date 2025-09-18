//앞에서부터 차근차근 최소공배수 구하기

class Solution {
    public int solution(int[] arr) {
        int a = arr[0];
        for (int i = 1; i < arr.length; i++) {
            a = lcm(a , arr[i]);
        }
        
        return a;
    }
    
    public int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a; 
    }
}