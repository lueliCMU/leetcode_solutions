class GenerateParentheses(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        cur_str = ''
        self.dfs(res, cur_str, n, 0, 0)
        return res
    
    def dfs(self, res, cur_str, total, left, right):
        if left == total and right == total:
            res.append(cur_str)
            return
        if left > right:
            self.dfs(res, cur_str + ')', total, left, right + 1)
        
        if left < total:
            self.dfs(res, cur_str + '(', total, left + 1, right)