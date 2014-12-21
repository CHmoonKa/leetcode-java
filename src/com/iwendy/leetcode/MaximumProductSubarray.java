package com.iwendy.leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 */
public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] a = new int[]{-2,3,-4};
		
		System.out.println(maxProduct(a));
	}
	
	public static int maxProduct(int A[]) {
        if(A==null||A.length==0) {
	      return 0;
	    }
	    int maxProduct = A[0];
	    int max_temp   = A[0];
	    int min_temp   = A[0];
	    
	    for(int i=1;i<A.length;i++) {
	    	int a = A[i]*max_temp;
	    	int b = A[i]*min_temp;
	    	max_temp = Math.max(Math.max(a,b), A[i]);
	    	min_temp = Math.min(Math.min(a,b), A[i]);
	    	maxProduct = Math.max(maxProduct, max_temp);
	    }
	    return maxProduct;
    }
	
	public static int maxProduct_2(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		
		int len = A.length;
		int max = A[0];
		
		// 分别针对正负进行处理，当是0时，重新计算
		int pos = Math.max(0, A[0]);
		int neg = Math.min(0, A[0]);
		
		for(int i=1; i<len; i++)
		{
			if(A[i] == 0){
				pos = neg = 0;
			}else if(A[i] > 0){
				pos = Math.max(1, pos)*A[i]; // 当pos为0时，pos = 1*A[i]
				neg = Math.min(0, neg)*A[i];
			}else{
				int tmp = pos;
				pos = neg*A[i];//neg may be 0
				neg = Math.min(A[i], tmp*A[i]); // pos可能为0，所以要用min
			}
			
			max = Math.max(max, pos);
		}
		return max;
	}
	
	//time out
	public int maxProduct_1(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		
		int len = A.length;
		int max = A[0];
		/**
		 * dp[i][j]为A[i]到A[j]的乘积
		 * dp[i][j] = dp[i][j-1]*A[j]
		 */
		int[][] dp = new int[len][len];
		for(int i=0; i<len; i++)
		{
			for(int j=i; j<len; j++)
			{
				if(j == i)
				{
					dp[i][i] = A[j];//就是自身
				}else
				{
					dp[i][j] = dp[i][j-1]*A[j]; //到这里时，j>i
				}
				
				if(dp[i][j] > max){
					max = dp[i][j];
				}
			}
		}
		return max;
	}
}
