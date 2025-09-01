class Solution {
    public int solution(int[] nums) {
        int maxSum = 3000; 
        boolean[] isComposite = sieve(maxSum); 

        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (!isComposite[sum]) count++; 
                }
            }
        }
        return count;
    }

    private boolean[] sieve(int limit) {
        boolean[] comp = new boolean[limit + 1];
        comp[0] = true; comp[1] = true;
        for (int p = 2; p * p <= limit; p++) {
            if (!comp[p]) {
                for (int m = p * p; m <= limit; m += p) comp[m] = true;
            }
        }
        return comp;
    }
}
