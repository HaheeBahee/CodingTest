import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputTokens = new StringTokenizer(reader.readLine());

        int vertexCount = Integer.parseInt(inputTokens.nextToken());
        int edgeCount = Integer.parseInt(inputTokens.nextToken());

        // 그래프 인접 리스트 초기화
        List<Integer>[] adjacencyList = new ArrayList[vertexCount + 1];
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            adjacencyList[vertex] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < edgeCount; i++) {
            inputTokens = new StringTokenizer(reader.readLine());
            int fromVertex = Integer.parseInt(inputTokens.nextToken());
            int toVertex = Integer.parseInt(inputTokens.nextToken());
            adjacencyList[fromVertex].add(toVertex);
            adjacencyList[toVertex].add(fromVertex);
        }

        boolean[] isVisited = new boolean[vertexCount + 1];
        int connectedComponentCount = 0;

        // 모든 정점을 순회하며 연결 요소 탐색
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            if (isVisited[vertex]) continue;

            connectedComponentCount++;
            exploreComponentWithBFS(vertex, adjacencyList, isVisited);
        }

        System.out.println(connectedComponentCount);
    }

    private static void exploreComponentWithBFS(int startVertex, List<Integer>[] adjacencyList, boolean[] isVisited) {
        Queue<Integer> vertexQueue = new ArrayDeque<>();
        vertexQueue.offer(startVertex);
        isVisited[startVertex] = true;

        while (!vertexQueue.isEmpty()) {
            int currentVertex = vertexQueue.poll();

            for (int adjacentVertex : adjacencyList[currentVertex]) {
                if (isVisited[adjacentVertex]) continue;

                isVisited[adjacentVertex] = true;
                vertexQueue.offer(adjacentVertex);
            }
        }
    }
}
