class Solution {
    public int solution(int n) {
        String base3 = Integer.toString(n, 3);
        String reverse = new StringBuilder(base3).reverse().toString();
        
        int base10 = Integer.parseInt(reverse,3);
        
        
        
        
        return base10;
    }
}