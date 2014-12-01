package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	
	For example:
	Given "25525511135",
	
	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 4){
        	return res;
        }
        if(s.length() == 4){
          String t = s.charAt(0) + ".";
          t += s.charAt(1) + ".";
          t += s.charAt(2) + ".";
          t += s.charAt(3);
          res.add(t);
          return res;
        }
        
        dfs(s,0,0,"",res);
        return res;
	}

  void dfs(String s, int start, int partNum, String list, List<String> res) {
    // IP的每一段,最多是3位数字
    if (s.length() - start > (4 - partNum) * 3) return;
    
    // IP的每一段,最少是1位数字
    if (s.length() - start < (4 - partNum)) return;
    
    // 当找到4段,并且刚好用完所有字符,则成功.
    if (start == s.length() && partNum == 4) 
    {
      res.add(list.substring(0, list.length()-1));
      return;
    }
    
    int sum = 0;
    //对IP的每一段,最多是3个字符
    for (int i = start; i<s.length() && i<start + 3; i++) 
    {
      sum = sum * 10 + (s.charAt(i) - '0');
      if (sum <= 255) {
        list += s.charAt(i);
        dfs(s, i + 1, partNum + 1, list+".", res);
      }
      
      if (sum == 0)//正常的不能以 0 起头.(01.)
      {
        break;
      }
    }//for
  }
}
