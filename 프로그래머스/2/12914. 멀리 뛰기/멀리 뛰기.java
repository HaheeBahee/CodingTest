//F(n)=F(n-1)+F(n-2) 피보나치 점화식으로 n칸 도달 경우의 수 구하기

class Solution {
    public long solution(int n) {
        int MOD = 1234567;
        if (n == 1) return 1;   
        long a = 1; //F(i-1)         
        long b = 2; //F(i-2)           
        for (int i = 3; i <= n; i++) {
            long c = (a + b) % MOD; // F(i) = F(i-1) + F(i-2)
            a = b;
            b = c;
        }
        return b % MOD;
    }
}
