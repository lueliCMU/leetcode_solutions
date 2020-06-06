
public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] chars = new int[128];
        int end = 0;
        int start = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            while (chars[c] > 0) {
                chars[s.charAt(start)]--;
                start++;
            }
            chars[c]++;
            max = Math.max(max, end - start + 1);
            end++;
        }
        max = Math.max(max, end - start);
        return max;
    }
}