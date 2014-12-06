package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
	
	public List<Integer> getRow_2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        
        res.add(1);
        for(int i=1; i<=rowIndex; i++){
        	res.add(1);
        	int index = res.size()-2;
        	for(int j=index; j>0; j--){
        		res.set(j, res.get(j)+res.get(j-1));
        	}
        }
        
        return res;
    }
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        
        res.add(1);
        for(int i=0; i<rowIndex; i++){
        	int size = res.size();
        	List<Integer> t = new ArrayList<>();
        	t.add(1);
        	for(int j=1; j<size; j++){
        		t.add(res.get(j-1) + res.get(j));
        	}
        	t.add(1);
        	res = t;
        }
        
        return res;
    }
}
