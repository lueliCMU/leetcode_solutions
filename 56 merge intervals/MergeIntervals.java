public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0;
        int e = 0;
        List<int[]> res = new ArrayList<>();
        while (e < end.length) {
            if (e < end.length - 1 && end[e] >= start[e + 1]) {
                e++;
            } else {
                res.add(new int[]{start[s], end[e]});
                e++;
                s = e;
            }
        }
        int[][] ret = new int[res.size()][2];
        int i = 0;
        for (int[] interval : res) {
            ret[i][1] = interval[1];
            ret[i][0] = interval[0];
            i++;
        }
        return ret;
    }
}