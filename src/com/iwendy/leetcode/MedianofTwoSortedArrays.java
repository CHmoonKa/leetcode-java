package com.iwendy.leetcode;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *  Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * */
public class MedianofTwoSortedArrays {
	/**
	 * [], [2,3] --> 2.5
	 * 
	 * 思路2: 内存辅助，将A，B先顺序放入一个数组，直接取中值即可。
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
        if((A == null || A.length == 0) && (B == null || B.length == 0))
        {
        	return 0;
        }
        if(A == null || A.length == 0){
        	int l = B.length;
        	return l%2 == 0? (B[l/2] + B[l/2-1])/2.0D : B[l/2];
        }
        
        if(B == null || B.length == 0){
        	int l =A.length;
        	return l%2 == 0? (A[l/2] + A[l/2-1])/2.0D : A[l/2];
        }
        
        int m = A.length;
        int n = B.length;
        
        int mid = (m + n)/2;
        int pre = 0;
        int res = 0;
        int i = 0;
        int j = 0;
        while(mid >= 0){
        	if(i < m && j < n && A[i] <= B[j]){
        		pre = res;
        		res = A[i];
        		i++;
        	}else if(i < m && j < n && A[i] > B[j]){
        		pre = res;
        		res = B[j];
        		j++;
        	}else if( i == m){
        		pre = res;
        		res = B[j];
        		j++;
        	}else{
        		pre = res;
        		res = A[i];
        		i++;
        	}
        	mid--;
        }
        
        return (m+n)%2 == 0 ? (pre + res)/2.0D : res;
    }
}
