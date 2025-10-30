function solution(number, k) {
  const stack = [];

  for (const ch of number) {
    while (k > 0 && stack.length && stack[stack.length - 1] < ch) {
      stack.pop();
      k--;
    }
    stack.push(ch);
  }

  if (k > 0) stack.splice(stack.length - k, k);
  return stack.join('');
}
