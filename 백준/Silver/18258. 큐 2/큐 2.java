import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char c = s.charAt(0);

            if (c == 'p') { 
                if (s.charAt(1) == 'u') {
                    int x = Integer.parseInt(s.substring(5));
                    q.addLast(x);
                } else { 
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
                }
            } else if (c == 's') {
                sb.append(q.size()).append('\n');
            } else if (c == 'e') {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (c == 'f') {
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
            } else {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
