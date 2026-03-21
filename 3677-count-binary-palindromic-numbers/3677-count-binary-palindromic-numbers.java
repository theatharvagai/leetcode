class Solution {
    public int countBinaryPalindromes(long n) {
        if (n == 0) return 1;

        String s = Long.toBinaryString(n);
        int len = s.length();
        int ans = 0;

        for (int i = 1; i < len; i++) {
            int h = (i + 1) / 2;
            ans += 1 << (h - 1);
        }

        int h = (len + 1) / 2;

        long firstHalf = Long.parseLong(s.substring(0, h), 2);
        long base = 1L << (h - 1);

        ans += (firstHalf - base);

        long pal = build(firstHalf, len % 2 == 1);

        if (pal <= n) ans++;

        return ans + 1;
    }

    private long build(long x, boolean odd) {
        long res = x;
        if (odd) x >>= 1;

        while (x > 0) {
            res = (res << 1) | (x & 1);
            x >>= 1;
        }
        return res;
    }
}