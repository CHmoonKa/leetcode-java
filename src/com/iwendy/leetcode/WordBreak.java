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
  /**
   * F(0, N) = F(0, i) && F(i, j) && F(j, N);
   * 一个字符串能否字典化,就是看是否可以分成几段
   */
	public boolean wordBreak(String s, Set<String> dict) {
	  if(s == null || s.length() == 0){
	    return true;
	  }
	  if(dict == null || dict.size() == 0){
	    return false;
	  }
	  
	  int len = s.length();
	  boolean[] dp = new boolean[1+len];
	  /**
	   * dp[0]代表 "",即s的第一个字符的前一个.
	   * 所以以下的i从1开始.
	   */
	  dp[0] = true;
	  
	  for(int i=1; i<=len; i++)//对每一个字符进行判断
	  {
	    for(int j=0; j<i; j++)//j是判断子串的
	    {
	      if(dp[j] && dict.contains(s.subSequence(j, i)))
	      {
	        dp[i] = true;
	        break;
	      }
	    }//j
	  }//i
	  
	  /**
	   * 如果最后一个都是true,证明可以.
	   */
	  return dp[len];
	}
	
	//dfs 
	//Time Limit Exceeded
	public boolean wordBreak_2(String s, Set<String> dict) {
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
