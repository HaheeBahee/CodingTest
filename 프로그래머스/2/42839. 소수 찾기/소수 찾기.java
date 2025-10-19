import java.util.*;

class Solution {
    private final Set<Integer> uniqueNumbers = new HashSet<>();
    private boolean[] isDigitUsed;
    private char[] digits;

    public int solution(String numbers) {
        digits = numbers.toCharArray();
        isDigitUsed = new boolean[digits.length];

        buildNumbers(new StringBuilder(), 0);

        int primeCount = 0;
        for (int value : uniqueNumbers) {
            if (isPrime(value)) primeCount++;
        }
        return primeCount;
    }

    private void buildNumbers(StringBuilder current, int depth) {
        if (current.length() > 0) {
            uniqueNumbers.add(Integer.parseInt(current.toString()));
        }
        if (depth == digits.length) return;

        for (int i = 0; i < digits.length; i++) {
            if (isDigitUsed[i]) continue;

            isDigitUsed[i] = true;
            current.append(digits[i]);

            buildNumbers(current, depth + 1);

            current.deleteCharAt(current.length() - 1);
            isDigitUsed[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        int limit = (int) Math.sqrt(n);
        for (int d = 3; d <= limit; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
