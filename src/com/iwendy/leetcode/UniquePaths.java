package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. 
	The robot is trying to reach the bottom-right corner of the grid 
	(marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
	
	Note: m and n will be at most 100.
 */
public class UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 4));
		System.out.println(uniquePathsBackTrack(3, 4));
	}
	
	// 动态规划
	public static int uniquePaths(int m, int n) {
		if(m == 1 || n == 1)
		{
			return 1;
		}
        int[][] table = new int[m][n];
        //將第一行，和第一列，設置爲1，因爲他們只有一種可能
        Arrays.fill(table[0], 1);
        for(int k=0; k<m; k++){
        	table[k][0] = 1;
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		table[i][j] = table[i-1][j] + table[i][j-1];
        	}
        }
        return table[m-1][n-1];
    }
	
	// 回溯法
	static int uniquePathsBackTrack(int m, int n) {  
        if(m==1 || n==1) return 1;  
        return uniquePathsBackTrack(m-1, n) + uniquePathsBackTrack(m, n-1);  
    } 
}
