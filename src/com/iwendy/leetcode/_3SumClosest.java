package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _3SumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] num, int target) {  
		if (num.length == 3) {  
	        return num[0] + num[1] + num[2];  
	    } 
		
	    Arrays.sort(num);
	    int min = Math.abs(num[0] + num[1] + num[2] - target);  
	    int result = 0;   
	    
	    for (int i = 0; i <= num.length - 3; i++) {  
	        int a = i, b = i + 1, c = num.length - 1;  
	        while (b < c) {  
	            if (num[a] + num[b] + num[c] - target > 0) {  
	                if (Math.abs(num[a] + num[b] + num[c] - target) <= min) {  
	                    min = Math.abs(num[a] + num[b] + num[c] - target);  
	                    result = num[a] + num[b] + num[c];  
	                }  
	                c--;  
	            } else {  
	                if (Math.abs(num[a] + num[b] + num[c] - target) <= min) {  
	                    min = Math.abs(num[a] + num[b] + num[c] - target);  
	                    result = num[a] + num[b] + num[c];  
	                }  
	                b++;  
	            }  
	        }  
	    }  
	    return result;  
	  
	   } 
}
