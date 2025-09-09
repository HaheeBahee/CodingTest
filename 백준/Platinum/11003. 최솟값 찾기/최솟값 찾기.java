import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt(), L = fs.nextInt();

        int[] qVal = new int[N];   
        int[] qIdx = new int[N];  
        int head = 0, tail = 0;

        StringBuilder sb = new StringBuilder(N * 3);

        for (int i = 0; i < N; i++) {
            int x = fs.nextInt();

            while (tail > head && qVal[tail - 1] > x) tail--;
            qVal[tail] = x; qIdx[tail] = i; tail++;

            while (qIdx[head] <= i - L) head++;

            sb.append(qVal[head]).append(' ');
        }
        System.out.print(sb);
    }
}
