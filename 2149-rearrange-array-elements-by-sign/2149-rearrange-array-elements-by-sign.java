class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int p = 0, ne = 0;

        // Step 1: Separate positives and negatives
        for (int num : nums) {
            if (num > 0) {
                pos[p++] = num;
            } else {
                neg[ne++] = num;
            }
        }

        // Step 2: Fill result array alternately
        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        while (k < n) {
            result[k++] = pos[i++]; // positive
            result[k++] = neg[j++]; // negative
        }

        return result;
    }
}