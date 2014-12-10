package com.iwendy.leetcode;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public boolean wordBreak_2(String s, Set<String> dict) {
		if(s == null || "".equals(s))return true;
		
		for(String t : dict){
			if(s.startsWith(t)){
				if(wordBreak(s.substring(t.length(),s.length()), dict)){
					return true;
				}
			}
		}
		return false;
	}
	
	//dfs 
	//Time Limit Exceeded
	public boolean wordBreak(String s, Set<String> dict) {
		if(s == null || "".equals(s))return true;
		
       for(int i=0; i<s.length(); i++){
    	   String pre = s.substring(0,i+1);
    	   if(dict.contains(pre)){
    		  if(wordBreak(s.substring(i+1, s.length()), dict)){
    			  return true;
    		  }
    	   }
       }
       
       return false;
    }
}
