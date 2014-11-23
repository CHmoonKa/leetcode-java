package com.iwendy.leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */
public class DivideTwoIntegers {
	
	// 1. 可以使用连续 减去 divisor 
	// 2. 可以连续加法 
	// 3. 除数向左移位(×2)然后与被除数比较，直到发现仅次于被除数的那个值，减去该值后继续。
	// 4. 如果可以用乘的话，二分搜索倒是不错的解法。
	public int divide(int dividend, int divisor) {
		if(divisor==0)
	        return Integer.MAX_VALUE;
	    
	        int res = 0;
	        boolean isNeg = ((dividend^divisor)>>>31==1)?true:false;
	        long a = Math.abs((long)dividend);  
	        long b = Math.abs((long)divisor); 
	        
	        // 以下的c有可能左移很大，则a不会减c，所以需要while(a >= b)
	        while(a >= b){
	            long c = b;  
	            for(int i = 0; a >= c; i++, c <<=1)  
	            {  
	                a -= c;  
	                res += 1<<i;  
	            } 
	        }
	        
	        return isNeg ? -res : res;
    }
}
