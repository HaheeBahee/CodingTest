import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjacencyList;
    static boolean[] isVisited;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력 (정점 개수, 간선 개수, 시작 정점)
        String[] firstLine = reader.readLine().split(" ");
        int nodeCount = Integer.parseInt(firstLine[0]);
        int edgeCount = Integer.parseInt(firstLine[1]);
        int startNode = Integer.parseInt(firstLine[2]);

        adjacencyList = new ArrayList[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < edgeCount; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int fromNode = Integer.parseInt(edgeInfo[0]);
            int toNode = Integer.parseInt(edgeInfo[1]);
            adjacencyList[fromNode].add(toNode);
            adjacencyList[toNode].add(fromNode);
        }

        // 정점 번호가 작은 순서대로 방문하도록 정렬
        for (int i = 1; i <= nodeCount; i++) {
            Collections.sort(adjacencyList[i]);
        }

        // DFS
        isVisited = new boolean[nodeCount + 1];
        depthFirstSearch(startNode);
        output.append('\n');

        // BFS
        isVisited = new boolean[nodeCount + 1];
        breadthFirstSearch(startNode);

        System.out.print(output.toString());
    }

    // 깊이 우선 탐색 (DFS)
    static void depthFirstSearch(int currentNode) {
        isVisited[currentNode] = true;
        output.append(currentNode).append(' ');

        for (int nextNode : adjacencyList[currentNode]) {
            if (!isVisited[nextNode]) {
                depthFirstSearch(nextNode);
            }
        }
    }

    // 너비 우선 탐색 (BFS)
    static void breadthFirstSearch(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();
        isVisited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            output.append(currentNode).append(' ');

            for (int nextNode : adjacencyList[currentNode]) {
                if (!isVisited[nextNode]) {
                    isVisited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}
