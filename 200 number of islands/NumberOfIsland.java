
public class NumberOfIsland {
    /**
     * 
     * DFS solution, use boolean[][] to record which cell is already visited.
     * 
     */
    public int numIslands1(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j]) {
            dfs(i - 1, j, grid, visited);
        }
        if (i < grid.length - 1 && !visited[i + 1][j]) {
            dfs(i + 1, j, grid, visited);
        }
        if (j > 0 && !visited[i][j - 1]) {
            dfs(i, j - 1, grid, visited);
        }
        if (j < grid[0].length - 1 && !visited[i][j + 1]) {
            dfs(i, j + 1, grid, visited);
        }
    }



    /**
     * 
     * UnionFind: use typical union find soltion
     */
    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int zero = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // we only check left and above cell to avoid check twice
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                } else {
                    zero++;
                }
            }
        }
        return uf.getTotal() - zero;
    }
    
    class UnionFind {
        int[] rank;
        int[] parent;
        int total;
        public UnionFind(int n) {
            total = n;
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int val) {
            while (val != parent[val]) {
                val = parent[parent[val]];
            }
            return val;
        }
        
        public void union(int a, int b) {
            int parenta = find(a);
            int parentb = find(b);
            if (parenta == parentb) return;
            if (rank[parenta] > rank[parentb]) {
                parent[parentb] = parenta;
            } else {
                if (rank[parenta] == rank[parentb]) {
                    rank[parentb]++;
                }
                parent[parenta] = parentb;
            }
            total--;
        }
        
        public int getTotal() {
            return total;
        }
        
    }
}