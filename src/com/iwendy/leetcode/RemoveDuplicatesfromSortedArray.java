package com.iwendy.leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		int len = A.length;
        if(len <= 1){
            return len;
        }
        int i = 0, j = 0;
        while(j < len){
            if(A[i] == A[j]){// 如果出现相同，则j继续往前找，直到找到不同于A[i]数
                j++;
            }else{
                i++;  // i跳动要被覆盖的重复那个数 
                A[i] = A[j]; // 用非重复的j覆盖重复的i
                j++; // 更新待检验的j
            }
        }
        return i+1;
    }
}
