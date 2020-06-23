public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int res = 0;
        for (int num : nums) {
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            curSum += num;
            if (map.containsKey(curSum - k)) {
                res += map.get(curSum - k);
            }
        }
        return res;
    }
}