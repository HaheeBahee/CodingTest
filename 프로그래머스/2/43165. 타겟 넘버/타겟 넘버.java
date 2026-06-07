// 순서 바꾸지 않고 더하거나 빼서 타겟 넘버 만들기
// 인풋: 사용할 양수 정수들, 아웃풋: 타겟 넘버 만들 수 있는 방법 개수
// 순서 바뀌지 않고 +- 둘 중 하나 선택하며 뻗어나감 => 이진 트리


class Solution{
    
    int count = 0;
    
    public int solution(int[] numbers, int target){
       
        int index = 0;
        int currentSum = 0;
        dfs(index, currentSum, numbers, target);
        return count;
    }
    


    public void dfs(int index, int currentSum, int[] numbers, int target){
        // 종료 시점 
        if (index == numbers.length){
            if(currentSum == target){
                count++;
            }
            return;
        }
        
        // 다음 단계 
            dfs(index + 1, currentSum + numbers[index], numbers, target);
            dfs(index + 1, currentSum - numbers[index], numbers, target);
    }
}
