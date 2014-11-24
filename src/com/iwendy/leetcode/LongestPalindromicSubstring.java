package com.leetcode.solutions;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 回文(Palindromic)就是正序、逆序读取完全一样的字符串。
 * 如奇数位的“aba”、偶数位的“abba”
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String text = "bb";
    
    System.out.println(longestPalindrome_1(text));
    System.out.println(longestPalindrome_2(text));
    System.out.println(longestPalindrome_3(text));
  }
  
  public static String longestPalindrome_1(String s) {
    int len = s.length();
    if(len <= 1)return s;

    boolean[][] dp = new boolean[len][len];//dp[i][j]表示s[i..j]是否是回文
    
    int left = 0; 
    int max = 1;
    
    dp[0][0] = true;
    for (int i = 1; i < len; i++) {
      dp[i][i] = true;
      if (s.charAt(i - 1) == s.charAt(i)) {
        dp[i - 1][i] = true;
        left = i-1;
        max = 2;
      }
    }
    
    //枚举子串长度
    for (int k = 3; k <= len; k++) 
    {
      // 枚举子串起始位置,因此i最大到len-k.(len - k + k == len)
      for (int i = 0; i <= len - k; i++) 
      {
        int j = i + k -1;//与 i相对的字符位置
        // 长度为k时,首尾字符相同,并且第二个与倒数第二个也相同
        if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
          dp[i][j] = true;
          // 长度比k小,就更新
          if (max < k) 
          {
            left = i;
            max = k;
          }
        }
      }// i
    }// k
    return s.substring(left, left + max);
  }
  
  /**
   * 1. 以每个s[i]字符为中心，两边测试看以这个字符为中心的回文长度是多少
   * 2. 以每两个字符s[i-1]s[i]为中心，测试这两个字符是否相等，和以这两个字符为中心的回文有多长
  */
  public static String longestPalindrome_2(String s)   
  {  
      int n = s.length();  
      int left = 0;  
      int max = 1;  
      for (int i = 0; i < n; i++)  
      {  
        int temp = longestPalindrome_2_temp(s, i, i);  
          if (temp > max)  
          {  
              left = i - temp/2;  
              max = temp;  
          }  
      }  
      for (int i = 1; i < n; i++)  
      {  
          int temp = longestPalindrome_2_temp(s, i-1, i);  
          if (temp > max)  
          {  
              left = i - temp/2;  
              max = temp;  
          }  
      }  
      return s.substring(left, left+max);  
  }
  
  public static int longestPalindrome_2_temp(String s, int low, int up)  
  {  
      int n = s.length();  
      int max = 0;  
      if (low == up)  
      {  
          low--;  
          up++;  
          max = 1;  
      }  
      while (low>=0 && up<n && s.charAt(low) == s.charAt(up))  
      {  
          max+=2;  
          low--;  
          up++;  
      }  
      return max;  
  }
  
  public static String longestPalindrome_3(String s) {
    if(s == null)return s;
    
    String t = longestPalindrome_3_temp(s); 
    int n = t.length();  
    int[] a = new int[n];  
    int mid = 0, R = 0;  
    for (int i = 2; i < n-1; i++) {//前两个字符是"^#",最后两个是"#$",所以不需要计算  
         int j = 2*mid-i; // 找到i关于mid对称的位置 (i+j)/2 = mid     
         a[i] = (R > i) ? Math.min(R-i, a[j]) : 0;  

         // Attempt to expand palindrome centered at i  
         while (t.charAt(i + 1 + a[i]) == t.charAt(i - 1 - a[i]))  
                a[i]++;  
         // If palindrome centered at i expand past R,  
         // adjust center based on expanded palindrome.  
         if (i + a[i] > R) {  
               mid = i;  
               R = i + a[i];  
         }  
    }  
    // Find the maximum element in a.  
    int maxLen = 0;  
    int centerIndex = 0;  
    for (int i = 1; i < n-1; i++) {  
         if (a[i] > maxLen) {  
              maxLen = a[i];  
              centerIndex = i;  
          }  
    }   
    int left = (centerIndex - 1 - maxLen)/2;
    return s.substring(left, left + maxLen); 
  }
  
  public static String longestPalindrome_3_temp(String s)  
  {  
    int n = s.length();  
    if (n == 0) return "^$";  
    String ret = "^";  
    for (int i = 0; i < n; i++)  
        ret += "#" + s.substring(i, i+1);  
    ret += "#$";  
    return ret; 
  }

}
