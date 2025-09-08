import java.util.*;

//합배열로 구간합 출력하기
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //공백단위로 끊어읽음 
        int m = sc.nextInt();
        
    
        int[] sumArr = new int[n+1]; //합배열
        
        for(int i = 1; i <= n; i++){
            int num = sc.nextInt(); //입력과 동시에 합배열 만들기
            sumArr[i] = sumArr[i-1] + num;
        }
        
        //구간합 구하기
        for(int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = sumArr[end] - sumArr[start - 1];
            System.out.println(result);
        }
        
    }
}