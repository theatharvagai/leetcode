class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++) {
            int curr = value(s.charAt(i));

            if(i < n - 1 && curr < value(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum;
    }

    private int value(char c) {
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
    }
}