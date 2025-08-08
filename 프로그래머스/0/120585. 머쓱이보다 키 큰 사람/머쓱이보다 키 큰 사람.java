import java.util.Arrays;

class Solution {
    public int solution(int[] array, int height) {
    
        
        return (int) Arrays.stream(array) //IntStream 반환
            . filter((h) -> h > height) // 배열의 각 요소 h
            . count(); //long 반환
        
    
    }
}