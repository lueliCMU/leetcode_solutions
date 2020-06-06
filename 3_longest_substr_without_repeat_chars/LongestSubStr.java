
public class LongestSubStr {
    /**
     * Use a char array to store all characters in "current string" (from start
     * pointer to the end pointer)
     * 
     * Use end pointer to go through all characters in the string:
     * 
     * (1) if this character does not appear in the current string, add it to the
     * char array
     * 
     * (2) if this character does appear in the current string, increment start
     * pointer and delete all characters at which start pointer are pointing from
     * the char array to make sure that every characters can only appear once in the
     * current string.
     * 
     * Time : O(n) Space : O(1)
     */
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

    /**
     * Use a map to store index of current char. i.e.: <character, index of that
     * character>
     * 
     * Use start pointer and end pointer to represent the current string without
     * duplicate chars
     * 
     * Use end pointer to go through the string, when we found there is a key in map
     * for current character, we update start pointer to map.get(curChar) + 1. Thus,
     * we can make sure that between start pointer and end pointer, there are no
     * duplicate chars. Then, for each character, we need to update the index of
     * that char as end pointer.
     * 
     * Time: O(n) Space: O(n)
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            } else {
                max = Math.max(max, end - start + 1);
            }

            map.put(c, end);
            end++;
        }
        return max;
    }
}