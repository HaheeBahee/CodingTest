function solution(n, wires) {
  // 인접 리스트
  const graph = Array.from({ length: n + 1 }, () => []);
  for (const [a, b] of wires) {
    graph[a].push(b);
    graph[b].push(a);
  }

  const bfsCount = (start, banA, banB) => {
    const visited = Array(n + 1).fill(false);
    const queue = [start];
    let head = 0;
    visited[start] = true;
    let count = 0;

    while (head < queue.length) {
      const cur = queue[head++];
      count++;

      for (const next of graph[cur]) {
        // 끊은 간선은 무시
        if ((cur === banA && next === banB) || (cur === banB && next === banA)) continue;
        if (!visited[next]) {
          visited[next] = true;
          queue.push(next);
        }
      }
    }
    return count;
  };

  let answer = n; 
  for (const [a, b] of wires) {
    const sizeA = bfsCount(a, a, b);
    const sizeB = n - sizeA;
    answer = Math.min(answer, Math.abs(sizeA - sizeB));
  }
  return answer;
}
