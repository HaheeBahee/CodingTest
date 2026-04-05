import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //가로
        int m = scanner.nextInt(); //세로
        
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}