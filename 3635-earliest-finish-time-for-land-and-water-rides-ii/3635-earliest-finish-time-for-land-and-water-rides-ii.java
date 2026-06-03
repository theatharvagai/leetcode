import java.util.Arrays;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int[][] land = new int[n][2];
        for (int i = 0; i < n; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }

        int[][] water = new int[m][2];
        for (int j = 0; j < m; j++) {
            water[j][0] = waterStartTime[j];
            water[j][1] = waterDuration[j];
        }

        Arrays.sort(land, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(water, (a, b) -> Integer.compare(a[0], b[0]));

        int minFinishTime = Integer.MAX_VALUE;
        minFinishTime = Math.min(minFinishTime, solve(land, water));
        minFinishTime = Math.min(minFinishTime, solve(water, land));

        return minFinishTime;
    }

    private int solve(int[][] first, int[][] second) {
        int n = first.length;
        int m = second.length;

        int[] suffMinFinish = new int[m + 1];
        suffMinFinish[m] = Integer.MAX_VALUE;
        for (int j = m - 1; j >= 0; j--) {
            suffMinFinish[j] = Math.min(suffMinFinish[j + 1], firstTimeFinish(second[j]));
        }

        int[] prefMinDuration = new int[m];
        int currMin = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            currMin = Math.min(currMin, second[j][1]);
            prefMinDuration[j] = currMin;
        }

        int localMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int finish1 = firstTimeFinish(first[i]);

            int low = 0, high = m - 1;
            int idx = m;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (second[mid][0] > finish1) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (idx > 0) {
                localMin = Math.min(localMin, finish1 + prefMinDuration[idx - 1]);
            }
            if (idx < m) {
                localMin = Math.min(localMin, suffMinFinish[idx]);
            }
        }

        return localMin;
    }

    private int firstTimeFinish(int[] ride) {
        return ride[0] + ride[1];
    }
}