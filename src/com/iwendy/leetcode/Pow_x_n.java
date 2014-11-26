package com.iwendy.leetcode;

/**
 * Implement pow(x, n).
 */
public class Pow_x_n {

	//二分法
	public double pow_2(double x, int n) {
	    if (n == 0) return 1.0;
	    double half = pow(x, n/2);
	    if (n%2 == 0)
	    {
	        return half*half;
	    }
	    else if (n>0)
	    {
	        return half*half*x;
	    }
	    else
	    {
	        return half/x*half;
	    }
	}
	
	/**
	 * Runtime Error Message:	Line 3: java.lang.StackOverflowError
	 * Last executed input:	1.00000, -2147483648
	 */
	public double pow(double x, int n){
		if(n == 0)return 1.0;
		else if(n < 0){
			return 1/pow(x,-n);
		}
		else if(n % 2 == 0){
			return pow(x*x,n/2);
		}else{
			return pow(x*x,n/2)*x;
		}
	}
}
