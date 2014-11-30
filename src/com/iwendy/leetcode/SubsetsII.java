package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		
		if(num == null || num.length == 0){
			return res;
		}
		
		Arrays.sort(num);
		dfs(num,0,new ArrayList<Integer>(),res);
		
		return res;
    }
	
	void dfs(int[] num, int start, List<Integer> list, List<List<Integer>> res){
		for(int i=start; i< num.length; i++){
			list.add(num[i]);
			res.add(new ArrayList<Integer>(list));
			if(i < num.length - 1)
				dfs(num,i+1,list,res);
			list.remove(list.size()-1);
			
			while(i < num.length - 1 && num[i+1] == num[i]){
				i++;
			}
		}
	}
}
