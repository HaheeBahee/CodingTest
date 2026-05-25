// 한자리 숫자로 쪼개 -> 만들 수 있는 소수 개수 반환
// 순서 중요, 모든 경우의 수, for 문 여러개 -> 완전 탐색

import java.util.*;

class Solution{
    Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers){
        
        int[] intNum = new int[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            intNum[i] = numbers.charAt(i) - '0';
        }
        
        boolean[] visited = new boolean[numbers.length()];
        
        소수(intNum, 0, visited);
        return primes.size();
    }
    
    public void 소수(int[] intNum, int current, boolean[] visited){
        
        for(int i = 0; i < intNum.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(isPrime(current * 10 + intNum[i])) primes.add(current * 10 + intNum[i]);
            소수(intNum, current * 10 + intNum[i], visited);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2 ) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}