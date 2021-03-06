package com.iwendy.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

  If the last word does not exist, return 0.
  
  Note: A word is defined as a character sequence consists of non-space characters only.
  
  For example, 
  Given s = "Hello World",
  return 5.
 */
public class LengthofLastWord {
  public int lengthOfLastWord(String s) {
    if(s == null || s.length() == 0)
    {
      return 0;
    }
    String ss = s.trim();
    if(ss == null || ss.length() == 0){
      return 0;
    }
    int len = 1;
    int index = s.length()-2;
    while(index >= 0){
      if(ss.charAt(index) == ' ')break;
      len++;
      index--;
    }
    return len;
  }
}
