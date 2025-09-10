import java.io.*;
import java.util.*;

public class Main {
    static final byte[] buf = new byte[1 << 16];
    static int p, len;
    static int read() throws IOException {
        if (p >= len) { len = System.in.read(buf); p = 0; if (len < 0) return -1; }
        return buf[p++];
    }
    static int nextInt() throws IOException {
        int c, s = 1, v = 0;
        do c = read(); while (c <= 32);
        if (c == '-') { s = -1; c = read(); }
        while (c > 32) { v = v * 10 + c - '0'; c = read(); }
        return v * s;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = nextInt();

        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        int[] st = new int[N];
        int top = -1;

        for (int i = 0; i < N; i++) {
            while (top >= 0 && A[st[top]] < A[i]) ans[st[top--]] = A[i];
            st[++top] = i;
        }

        StringBuilder sb = new StringBuilder(N * 3);
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i]);
        }
        System.out.print(sb.toString());
    }
}
