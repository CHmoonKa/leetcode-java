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
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
        long dvd = Math.abs(dividend);
        long dvs = Math.abs(divisor);
        
        int sign = dividend > 0 ? 1 : -1;
        sign = divisor > 0 ? sign : -sign;
        int res = 0;
        
        int times = 0;
        while(dvs < dvd){
        	dvs = dvs << 1;
        	times++;
        }
        
        while(times >= 0){
        	if(dvd >= dvs){
        		dvd = dvd - dvs;
        		res = res + 1<<times;
        	}
        	dvs >>= 1;
        	times--;
        }
        
        return res*sign;
    }
}
