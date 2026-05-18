// 순서 바꾸지 않고 더하거나 빼서 타겟 넘버 만들기
// 인풋: 사용할 양수 정수들, 아웃풋: 타겟 넘버 만들 수 있는 방법 개수
// 순서 바뀌지 않고 +- 둘 중 하나 선택하며 뻗어나감 => 이진 트리

class Solution{
    int method = 0;

    public int solution(int[] numbers, int target){
        
        dfs(numbers,target,0,0);
        return method;

    }
    
    void dfs(int[] numbers, int target, int depth, int currentSum){
        // 종료 조건
        if(depth == numbers.length){
            if(currentSum == target){
                method++;
            }
            return;
        }
        
        dfs(numbers, target, depth + 1, currentSum + numbers[depth]);
        dfs(numbers, target, depth + 1, currentSum - numbers[depth]);
    }
}