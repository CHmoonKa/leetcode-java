package com.iwendy.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.
 */
public class Triangle {
	 public int minimumTotal(List<List<Integer>> triangle) {
	    int size = triangle.size();
	    if(size <= 0)return 0;
	    
	    int[] sum = new int[size];
	    sum[0] = triangle.get(0).get(0);
	    
	    for(int i=1; i<size; i++){
	    	List<Integer> t = triangle.get(i);
	    	sum[i] = sum[i-1] + t.get(i);
	    	
	    	for(int j=i-1; j>0; j--){
	    		sum[j] = t.get(j) + Math.min(sum[j-1], sum[j]);
	    	}
	    	
	    	sum[0] = sum[0] + t.get(0);
	    }
	    
	    Arrays.sort(sum);
	    
	    return sum[0];
	 }
}
