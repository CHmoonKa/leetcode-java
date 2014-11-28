package com.iwendy.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *  This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 */
public class Searcha2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int nr = matrix.length;
		int nc = matrix[0].length;
		
        int i = 0;
        int j = nr*nc - 1;
        while(i <= j){
        	int mid = (i+j)/2;
        	int r = mid/nc;
        	int c = mid%nc;
        	if(matrix[r][c] == target){
        		return true;
        	}else if(matrix[r][c] < target){
        		i = mid+1;
        	}else{
        		j = mid-1;
        	}
        }
        return false;
    }
	
	/**
	 * 可以先对第一列进行二分查找，锁定该元素所在行数，然后再对列进行二分查找，即可判断target是否存在。
	 */
}
