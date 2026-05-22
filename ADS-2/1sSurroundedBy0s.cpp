#include <bits/stdc++.h>
using namespace std;

class SurroundedBy0s
{
public:
    
    void dfs(int r, int c, int n, int m, vector<vector<int>> &grid)
    {
        // Base condition
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != 1)
        {
            return;
        }

        // Mark visited/escapable cells
        grid[r][c] = 2;

        // Explore 4 directions
        dfs(r + 1, c, n, m, grid);
        dfs(r - 1, c, n, m, grid);
        dfs(r, c + 1, n, m, grid);
        dfs(r, c - 1, n, m, grid);
    }

    int cntOnes(vector<vector<int>> &grid)
    {
        int n = grid.size();
        int m = grid[0].size();

        // Traverse boundary cells
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) 
                    && grid[i][j] == 1)
                {
                    dfs(i, j, n, m, grid);
                }
            }
        }

        // Count trapped 1s
        int trappedCount = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (grid[i][j] == 1)
                {
                    trappedCount++;
                }
            }
        }

        return trappedCount;
    }
};