package com.iwendy.leetcode;

/**
 * Follow up for "Unique Paths":
	
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.
 */
public class UniquePathsII {
	/**
	 * 遇到obstacleGrid[i][j] == 1的元素，即将path设为0即可。
	 * 但是注意在第一行和第一列，即obstacleGrid[i][0] == 1&& obstacleGrid[0][i] == 1后面的元素path全部置0
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0
    			|| obstacleGrid[0].length == 0){
    		return 0;
    	}
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] path = new int[m][n];
    	for(int i = 0; i < n; i++){
    		if(obstacleGrid[0][i] == 0){
    			path[0][i] = 1;
    		}else{
    			path[0][i] = 0;
    			break;
    		}
    	}
    	for(int i = 0; i < m; i++){
    		if(obstacleGrid[i][0] == 0){
    			path[i][0] = 1;
    		}else{
    			path[i][0] = 0;
    			break;
    		}
    	}
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 0){
					path[i][j] = path[i-1][j] + path[i][j-1];
				}
			}
		}
		return path[m-1][n-1];
    }
}
