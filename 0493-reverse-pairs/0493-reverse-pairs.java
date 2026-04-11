class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    int sort(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = (l + r) / 2;
        int count = sort(nums, l, m) + sort(nums, m + 1, r);

        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) nums[i] > 2L * nums[j]) j++;
            count += j - (m + 1);
        }

        merge(nums, l, m, r);
        return count;
    }

    void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= m) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[l + p] = temp[p];
        }
    }
}