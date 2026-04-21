class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[256];
            int len = 0;

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (seen[c]) break;
                seen[c] = true;
                len++;
            }

            if (len > max) max = len;
        }

        return max;
    }
}