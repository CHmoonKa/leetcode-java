package com.iwendy.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
	// Min[i][j] = min(Min[i-1][j], Min[i][j-1]) +A[i][j];
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
        	return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        // initial dp array  
        dp[0][0] = grid[0][0];  
        for (int i = 1; i < m; i++) {  
            dp[i][0] = dp[i - 1][0] + grid[i][0];  
        }  
        for (int j = 1; j < n; j++) {  
            dp[0][j] = dp[0][j - 1] + grid[0][j];  
        } 
        
        // dynamic process
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                dp[i][j] = dp[i - 1][j] <= dp[i][j - 1] ? 
                		dp[i - 1][j] + grid[i][j] : 
                		dp[i][j - 1] + grid[i][j];  
            }  
        }
        
        return dp[m - 1][n - 1]; 
    }
}
