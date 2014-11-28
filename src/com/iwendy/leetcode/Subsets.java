package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If S = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 */
public class Subsets {
	/**
	 *  一个思路就是套用combination的方法，其实combination那道题就是在求不同n下的subset
	 * 例如k=3，n=1，用combination那道题的方法求得集合是[[1], [2], [3]]；
		    k=3, n=2, 用combination那道题的方法求得集合是[[1, 2], [1, 3], [2, 3]]
		    k=3, n=3, 用combination那道题的方法求得集合是[[1,2,3]]
		所以上述3个集合外加一个空集就是
		
		思路2：
		对于输入字符串s的每一位字符
        选取该字符到子集合中，并输出
        如果，当前字符不是最后一位字符
        递归调用Generate,处理下一位字符
	 */
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(S == null || S.length ==0) return res;
		res.add(new ArrayList<Integer>());
		Arrays.sort(S);
		dfs(S, 0, new ArrayList<Integer>(), res);
		return res;
    }
	
	void dfs(int[] S, int start, List<Integer> list, List<List<Integer>> res){
		for(int i=start;i<S.length;i++){
			list.add(S[i]);
			res.add(new ArrayList<Integer>(list));
			if(i < S.length - 1){
				dfs(S, i+1, list, res);
			}
			list.remove(list.size()-1);
		}
	}
}
