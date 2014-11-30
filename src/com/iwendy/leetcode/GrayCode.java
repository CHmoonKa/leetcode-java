package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note: 
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(2));
	}
	/**
	 * n = 1:
	 *    0     
	 *    1     
	 * 
	 * n = 2:          
	 * 0| 0           
	 * 0| 1           
	 * --------        
	 * 1| 1     
	 * 1| 0
	 * 
	 * n=3:
	 * 0| 00
	 * 0| 01
	 * 0| 11
	 * 0| 10
	 * ------------
	 * 1| 10  ( Math.pow(2,n-2) + 前一个的倒序(10) )
	 * 1| 11
	 * 1| 01
	 * 1| 00
	 */
	public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if(n < 0){
        	return res;
        }
        res.add(0);
        if(n == 0){
        	return res;
        }
        
        res.add(1);
        if(n == 1){
        	return res;
        }
        
        for(int i=2;i <= n; i++){
        	int d = 2<<(i-2);
        	int size = res.size()-1;
        	for(int j=size;j >= 0; j--){
        		res.add(d + res.get(j));
        	}
        }
        return res;
    }
}
