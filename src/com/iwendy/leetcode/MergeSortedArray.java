package com.iwendy.leetcode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

	Note:
	You may assume that A has enough space (size that is greater or equal to m + n) to 
	hold additional elements from B. 
	The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	/**
	 * 将 A，B从后往前迭代
	 */
	public void merge(int A[], int m, int B[], int n) {
        int i = m + n -1;
        int ia = m - 1;
        int ib = n - 1;
        
        while(ia >= 0 && ib >= 0){
        	if(A[ia] >= B[ib]){
        		A[i] = A[ia];
        		i--;
        		ia--;
        	}else{
        		A[i] = B[ib];
        		i--;
        		ib--;
        	}
        }
        // A可以不用移动，因为已经在最前面了
        while(ia >= 0){
        	A[i] = A[ia];
        	i--;
        	ia--;
        }
        while(ib >= 0){
        	A[i] = B[ib];
        	i--;
        	ib--;
        }
    }
}
