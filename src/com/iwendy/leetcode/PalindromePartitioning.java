package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s == null || s.length() == 0)return res;
		
		dfs(s,res,new ArrayList<String>());
		return res;
    }
	
	public void dfs(String s, List<List<String>> res,List<String> list){
		if(s == null || s.length() == 0){
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int i=0; i<s.length();i++){
			if(isPalindrome(s.substring(0,i+1))){
				list.add(s.substring(0, i+1));
				dfs(s.substring(i+1),res,list);
				list.remove(list.size()-1);
			}
		}
	}
	
	public boolean isPalindrome(String sub){
		int s = 0;
		int e = sub.length()-1;
		while(s < e){
			if(sub.charAt(s) != sub.charAt(e)){
				return false;
			}
			s++;
			e--;
		}
		
		return true;
	}
}
