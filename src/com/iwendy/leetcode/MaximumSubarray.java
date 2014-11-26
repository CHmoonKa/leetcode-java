package com.iwendy.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.

	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	
	找到这个最大sum值
 */
public class MaximumSubarray {
	/**
	 * 局部最优和全局最优解法
	 * 假设我们已知第i步的global[i]（全局最优）和local[i]（局部最优），那么第i步的表达式是：
	 * 		local[i]=Math.max(A[i], local[i-1]+A[i])，
	 * 就是局部最优是一定要包含当前元素，所以不然就是上一步的局部最优local[i-1]+当前元素A[i]，
	 * 但是如果local[i-1]是负的(local[i-1]+A[i] < A[i])，那么加上他就不如不需要的，所以不然就是直接用A[i];
	 * 
	 * global[i]=Math.max(local[i],global[i])，有了当前一步的局部最优，
	 * 那么全局最优就是当前的局部最优或者还是原来的全局最优
	 */
	public int maxSubArray(int[] A) {
		if (A.length == 0 || A == null)
			return 0;
		int max = A[0];
		int tmp = A[0];
		for (int i = 1; i < A.length; i++) {
			tmp = Math.max(A[i], tmp + A[i]);
			max = Math.max(tmp, max);
		}
		return max;
	}
}
