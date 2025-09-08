import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();          
        long[] arr = new long[num]; 

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLong();      
        }

        Arrays.sort(arr);             

        int goodCount = 0;

        // 각 원소 arr[k]가 "좋은 수"인지 확인
        for (int k = 0; k < num; k++) {
            int i = 0;
            int j = num - 1;

            while (i < j) {
                if (i == k) { i++; continue; }
                if (j == k) { j--; continue; }

                long sum = arr[i] + arr[j];
                if (sum == arr[k]) {
                    goodCount++;
                    break;          
                }
                if (sum < arr[k]) i++;
                else j--;
            }
        }

        System.out.println(goodCount);
    }
}