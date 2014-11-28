package com.iwendy.leetcode;

/**
 * Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] A = new int[]{1,1,1,2,2,2,2,3};
		
		System.out.println(removeDuplicates(A));
	}
	public static int removeDuplicates(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		if(A.length <=1){
			return 1;
		}
        
		int i = 0;
		int j = 1;
		int size = 1;
		while(j < A.length)
		{
			if(A[i] == A[j])
			{
				if(size < 2){
					i++;
					A[i] = A[j];
					j++;
					size++;
				}else{
					j++;
				}
			}else{
				i++;
				A[i] = A[j];
				j++;
				size = 1;
			}
		}
		
		return i+1;
    }
}
