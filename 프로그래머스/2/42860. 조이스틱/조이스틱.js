function solution(name) { 
    const n = name.length;

    let upDown = 0;
    for (let i = 0; i < n; i++) {
    const ch = name.charCodeAt(i);
    upDown += Math.min(ch - 65, 91 - ch);
  }

    let leftRight = n - 1;
    for (let i = 0; i < n; i++) {
    let j = i + 1;
    while (j < n && name[j] === 'A') j++;

    leftRight = Math.min(leftRight, i * 2 + (n - j));
    leftRight = Math.min(leftRight, (n - j) * 2 + i);
  }

  return upDown + leftRight;
}
