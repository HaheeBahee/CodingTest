import java.io.*;
import java.util.*;

public class Main {
    static int[] need = new int[4], have = new int[4];
    static int satisfied = 0;

    static int idx(char c) { return "ACGT".indexOf(c); }

    static void add(char c) {
        int i = idx(c);
        have[i]++;
        if (have[i] == need[i]) satisfied++;
    }

    static void remove(char c) {
        int i = idx(c);
        if (have[i] == need[i]) satisfied--;
        have[i]--;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            if (need[i] == 0) satisfied++;
        }

        for (int i = 0; i < P; i++) add(dna[i]);
        int ans = (satisfied == 4) ? 1 : 0;

        for (int i = P; i < S; i++) {
            add(dna[i]);
            remove(dna[i - P]);
            if (satisfied == 4) ans++;
        }

        System.out.println(ans);
    }
}
