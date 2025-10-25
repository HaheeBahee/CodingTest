function solution(rectangle, characterX, characterY, itemX, itemY) {
  const MAX = 102;
  const board = Array.from({ length: MAX }, () => Array(MAX).fill(0));
  const visited = Array.from({ length: MAX }, () => Array(MAX).fill(false));

  // 1) 좌표 2배
  const rects = rectangle.map(([x1, y1, x2, y2]) => [x1*2, y1*2, x2*2, y2*2]);
  const sx = characterX * 2, sy = characterY * 2;
  const tx = itemX * 2, ty = itemY * 2;

  // 2) 직사각형 칠하기
  for (const [x1, y1, x2, y2] of rects) {
    for (let x = x1; x <= x2; x++) {
      for (let y = y1; y <= y2; y++) {
        board[x][y] = 1;
      }
    }
  }
  for (const [x1, y1, x2, y2] of rects) {
    for (let x = x1 + 1; x <= x2 - 1; x++) {
      for (let y = y1 + 1; y <= y2 - 1; y++) {
        board[x][y] = 0;
      }
    }
  }

  // 3) BFS (경계만 이동)
  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];
  const q = [[sx, sy, 0]];
  visited[sx][sy] = true;

  while (q.length) {
    const [x, y, d] = q.shift();
    if (x === tx && y === ty) return Math.floor(d / 2); 

    for (let dir = 0; dir < 4; dir++) {
      const nx = x + dx[dir];
      const ny = y + dy[dir];
      if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
      if (visited[nx][ny]) continue;
      if (board[nx][ny] !== 1) continue;
      visited[nx][ny] = true;
      q.push([nx, ny, d + 1]);
    }
  }

  return 0;
}
