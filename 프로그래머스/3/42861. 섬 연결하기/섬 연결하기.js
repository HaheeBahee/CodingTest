function solution(n, costs) {
  const graph = Array.from({ length: n }, () => []);
  for (const [a, b, cost] of costs) {
    graph[a].push([b, cost]);
    graph[b].push([a, cost]);
  }

  const visited = Array(n).fill(false);
  let totalCost = 0;
  let edgesUsed = 0;

  const pq = [[0, 0]];

  while (pq.length > 0 && edgesUsed < n) {
    pq.sort((a, b) => a[0] - b[0]);
    const [cost, node] = pq.shift();

    if (visited[node]) continue;
    visited[node] = true;
    totalCost += cost;
    edgesUsed++;

    for (const [next, nextCost] of graph[node]) {
      if (!visited[next]) {
        pq.push([nextCost, next]);
      }
    }
  }

  return totalCost;
}

