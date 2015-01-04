package com.iwendy.leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {
  public static void main(String[] args) {
   System.out.println(convertToTitle(27)); 
  }
  
  
  public static String convertToTitle(int n) {
    String res = "";
    while(n > 0){
      res = (char)('A' + (n-1)%26) + res;  
      n = (n-1) / 26;  
    }
    
    return res;
  }
}
