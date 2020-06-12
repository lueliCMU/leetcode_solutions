class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        
        for i in range(len(s)):
            if s[i] == '[' or s[i] == '(' or s[i] == '{':
                stack.append(s[i])
            elif s[i] == ']':
                if not stack or stack[-1] != '[':
                    return False
                stack.pop()
            elif s[i] == '}':
                if not stack or stack[-1] != '{':
                    return False
                stack.pop()
            elif s[i] == ')':
                if not stack or stack[-1] != '(':
                    return False
                stack.pop()
        
        return not stack