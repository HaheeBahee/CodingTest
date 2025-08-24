import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        quickSort(strings, 0, strings.length - 1, n);
        return strings;
    }

    // 퀵소트 재귀
    private void quickSort(String[] arr, int left, int right, int n) {
        if (left >= right) return;

        int l = left, r = right;
        String pivot = arr[(left + right) / 2];

        while (l <= r) {
            // pivot보다 작은 값 찾기
            while (compare(arr[l], pivot, n) < 0) l++;
            // pivot보다 큰 값 찾기
            while (compare(arr[r], pivot, n) > 0) r--;

            if (l <= r) {
                String tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }

        if (left < r) quickSort(arr, left, r, n);
        if (l < right) quickSort(arr, l, right, n);
    }

    private int compare(String a, String b, int n) {
        char ca = a.charAt(n);
        char cb = b.charAt(n);

        if (ca == cb) {
            return a.compareTo(b);
        } else {
            return Character.compare(ca, cb);
        }
    }
}