package com.iwendy.leetcode;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	
	/**
	 * 动态规划，dp[i] = dp[i-1] + dp[i-2]
	 */
	public int numDecodings(String s) {
		if (s == null || s.length()==0 || s.charAt(0) == '0') 
            return 0; 
		// dp[i]表示从1~i的decode ways的个数
        int[] dp = new int[s.length()+1]; 
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2;i<=s.length();i++) {  
            //检查当前字符是不是'0'
            if(s.charAt(i-1) != '0') {              
                dp[i] = dp[i-1];  
            }  
            //检查当前字符和前一个字符组合在一起是否在1-26之间  
            if(s.charAt(i-2) != '0') {  
                int tmp = Integer.parseInt(s.substring(i-2,i));  
                if(tmp > 0 && tmp <= 26) {  
                    dp[i] += dp[i-2];  
                }  
            }  
        }  
        return dp[s.length()]; 
    }
}
