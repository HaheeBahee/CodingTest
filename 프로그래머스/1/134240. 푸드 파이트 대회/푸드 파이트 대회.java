class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int half = food[i] / 2;       
            for (int k = 0; k < half; k++) left.append(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append(left).append('0').append(left.reverse());
        return answer.toString();
    }
}