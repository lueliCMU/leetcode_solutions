class Solution(object):
    def longestPalindrome1(self, s):
        """
        :type s: str
        :rtype: str
        """
        maxLen = 0
        start = 0
        end = 0
        for i in range(len(s)):
            tmp = self.helper(s, i, i)
            if tmp > maxLen:
                maxLen = tmp
                start = i - tmp / 2
                end = i + tmp / 2
            
            tmp = self.helper(s, i, i + 1)
            if tmp > maxLen:
                maxLen = tmp
                start = i - tmp / 2 + 1
                end = i + tmp / 2
        return s[start:end+1]
    
    def helper(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1