import java.io.*;
import java.util.*;

public class Main {
    static int targetLength;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        targetLength = Integer.parseInt(br.readLine().trim());

        int[] firstDigits = {2, 3, 5, 7};
        for (int d : firstDigits) dfs(d, 1);

        System.out.print(out);
    }

    static void dfs(int current, int digits) {
        if (!isPrime(current)) return;

        if (digits == targetLength) {
            out.append(current).append('\n');
            return;
        }
        int[] candidates = {1, 3, 7, 9};
        for (int add : candidates) {
            dfs(current * 10 + add, digits + 1);
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int limit = (int) Math.sqrt(n);
        for (int d = 3; d <= limit; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
