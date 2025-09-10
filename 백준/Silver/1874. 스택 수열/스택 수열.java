import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(br.readLine().trim());
        int[] target = new int[n];
        for (int i = 0; i < n; i++) target[i] = Integer.parseInt(br.readLine().trim());

        Deque<Integer> st = new ArrayDeque<>();
        int next = 1;
        for (int x : target) {
            while (next <= x) {
                st.push(next++);
                out.append("+\n");
            }
            if (!st.isEmpty() && st.peek() == x) {
                st.pop();
                out.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.print(out.toString());
    }
}
