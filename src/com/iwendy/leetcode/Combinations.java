package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 */
public class Combinations {
	
	public  List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n <=0 || k<= 0){
			return res;
		}
		
		dfs(1,n,k,new ArrayList<Integer>(),res);
		return res;
    }
	
   void dfs(int start,int n,int k, List<Integer> list, List<List<Integer>> res){
		if(k == 1){
			for(int j=start;j<=n;j++){
				list.add(j);
				res.add(new ArrayList<Integer>(list));
				list.remove(list.size()-1);
			}
			return;
		}
		for(int i = start;i<=n-k+1;i++){
			list.add(i);
			dfs(i+1,n,k-1,list,res);
			list.remove(list.size()-1);
		}
	}
}
