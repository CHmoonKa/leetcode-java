package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers, 
 * every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
        Arrays.sort(A);
        
        int s = 1;
        //如果最少的数字在最后，下面的for就判断不到了
        //所以需要将ret=最后一个
        int ret = A[A.length-1];
        for(int i=1; i<A.length; i++){
        	if(A[i] == A[i-1]){
        		s++;
        	}else{
        		if(s < 3){
        			ret = A[i-1];
        			break;
        		}else{
        			s = 1;
        		}
        	}
        }
        return ret;
    }
}
