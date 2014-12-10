package com.iwendy.leetcode;

/**
 * Given an array of integers, 
 * every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */
public class SingleNumber {
	/**
	 * 1. 用Map对每一个数据进行个数的记录，找到只有一个的那个数据
	 * 2. 先对A排序，看是否个数是2个
	 * 3. 两个数字亦或为0，最后剩下一个数字
	 */
	public int singleNumber(int[] A) {
        int t = 0;
        for(int i=0; i<A.length; i++){
        	t ^= A[i];
        }
        
        return t;
    }
}
