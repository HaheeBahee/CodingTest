//가로>=세로 되도록 회전


class Solution {
    public int solution(int[][] sizes){
        int max1 = 0;
        int max2 = 0;
        // 배열 두 요소 중 큰 걸 앞쪽(가로)에 배치
        for(int[] size : sizes){
            if(size[0] < size[1]){
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            } 
            if(size[0] > max1) max1 = size[0];
            if(size[1] > max2) max2 = size[1];
        }
        return max1 * max2;
    }

}