package com.iwendy.leetcode;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

	click to show follow up.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		// 用来标记第一行和第一列是否在一开始就有0的存在
		boolean rowZero = false, colZero = false;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colZero = true;
				break;
			}
		}

		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowZero = true;
				break;
			}
		}

		// 在矩阵中查找0，标记在行头和列头
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 根据列头，把矩阵相应位置置零
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// 根据行头，把矩阵相应位置置零
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		// 处理第一行
		if (rowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		// 处理第一列
		if (colZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
