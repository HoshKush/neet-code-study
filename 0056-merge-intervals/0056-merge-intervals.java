class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        List<int[]> newIntervals = new ArrayList<>();
        int startIdx = 0;
        int curEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(curEnd < intervals[i][0]) {
                newIntervals.add(new int[]{intervals[startIdx][0], curEnd});
                startIdx = i;
            }
            curEnd = Math.max(curEnd, intervals[i][1]);
        }
        if(startIdx != intervals.length - 1) {
            newIntervals.add(new int[]{intervals[startIdx][0], curEnd});
        } else {
            newIntervals.add(intervals[intervals.length - 1]);
        }

        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }
}