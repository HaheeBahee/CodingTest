import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            if (x == 0) stack.pop();
            else stack.push(x);
        }

        int sum = 0;
        for (int v : stack) sum += v;
        System.out.println(sum);
    }
}

