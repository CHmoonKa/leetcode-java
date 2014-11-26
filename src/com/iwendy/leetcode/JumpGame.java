package com.iwendy.leetcode;

/**
 * Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump(最多可以跳的步) length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int maxCover = 0;
		int n = A.length;
		for (int start = 0; start <= maxCover && start < n; start++) {
			if (A[start] + start > maxCover)
				maxCover = A[start] + start;
			if (maxCover >= n - 1)
				return true;
		}
		return false;
	}
}
