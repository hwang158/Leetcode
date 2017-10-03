// Union and find
class Solution {
    class UF {
        public int count = 0;
        public int[] id;
        
        public UF(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
            
            id = new int[m * n];
            for (int k = 0; k < m * n; k++) {
                id[k] = k;
            }
        }
        
        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int a = find(p);
            int b = find(q);
            if (a == b) {
                return;
            }
            id[a] = b;
            count--;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m, n, grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int p = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(p, p - n);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(p, p - 1);
                }
            }
        }
        return uf.count;
    }
}

// Solution 2:
// DFS and change the grid if its connected
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }
}