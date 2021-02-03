public class TaskSceduler {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        int max = 0;
        int maxCount = 0;
        for (int num : map) {
            if (max < num) {
                max = num;
                maxCount = 1;
            } else if (max == num) {
                maxCount++;
            }
        }
        
        int emptySlots = (n - maxCount + 1) * (max - 1);
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }

    // explanation: https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
}
