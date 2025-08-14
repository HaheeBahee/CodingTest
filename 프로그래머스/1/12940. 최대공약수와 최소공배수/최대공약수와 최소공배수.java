class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = (n * m) / gcd;
        return new int[]{gcd, lcm};
    }
    
    // 최대공약수 계산 (유클리드 호제법)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}