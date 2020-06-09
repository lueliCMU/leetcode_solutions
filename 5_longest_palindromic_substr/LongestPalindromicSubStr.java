
public class LongestPalindromicSubStr {
    /**
     * Go through each character of this string and check two types of
     * palinsromic string and update max length, start and end
     * 
     */
    public String longestPalindrome1(String s) {
        if (s.length() == 0) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = checkPal(s, i, i);
            if (max < len) {
                max = len;
                start = i - (len - 1) / 2;
                end = i + (len - 1) / 2;
            }
            len = checkPal(s, i, i + 1);
            if (max < len) {
                max = len;
                start = i - len / 2 + 1;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int checkPal(String s, int left, int right) {
        if (right >= s.length()) {
            return 0;
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }
    /**
     * Dynamic programming:
     * dp[i][j] represents if s[i:j] is palindromic.
     * 
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n == 0) return s;
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];
        
        // dp[i][j] depends on dp[i + 1][j - 1]
        // so for i, we need to go through from n - 1 to 0
        // for j, we need to go through from i to n (j >= i)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}