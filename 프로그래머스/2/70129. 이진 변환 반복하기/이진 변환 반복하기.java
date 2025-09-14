class Solution {
    public int[] solution(String s) {
        int transforms = 0;
        int zerosRemoved = 0;

        while (!s.equals("1")) {
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zeros++;
            }
            zerosRemoved += zeros;

            int ones = s.length() - zeros;
            s = Integer.toBinaryString(ones);

            transforms++;
        }

        return new int[] { transforms, zerosRemoved };
    }
}
