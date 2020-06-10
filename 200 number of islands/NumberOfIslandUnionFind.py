
class UnionFind(object):
    def __init__(self, n):
        self.count = n
        self.parent = [0] * n
        self.rank = [0] * n
        for i in range(n):
            self.parent[i] = i
    
    def find(self, val):
        while val != self.parent[val]:
            val = self.parent[self.parent[val]]
        return val
    
    def union(self, x, y):
        rootx = self.find(x)
        rooty = self.find(y)
        
        if rootx != rooty:
            if self.rank[rootx] > self.rank[rooty]:
                self.parent[rooty] = rootx
            elif self.rank[rootx] < self.rank[rooty]:
                self.parent[rootx] = rooty
            else:
                self.parent[rooty] = rootx
                self.rank[rootx] += 1
            self.count -= 1

class Solution(object):
    def numIslands_unionfind(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        uf = UnionFind(m * n)
        zero = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    if i > 0 and grid[i - 1][j] == '1':
                        uf.union(i * n + j, (i - 1) * n + j)
                    if j > 0 and grid[i][j - 1] == '1':
                        uf.union(i * n + j, i * n + j - 1)
                else:
                    zero += 1
        return uf.count - zero