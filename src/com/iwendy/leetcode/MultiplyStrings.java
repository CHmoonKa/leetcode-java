package com.iwendy.leetcode;

/**
 * Given two numbers represented as strings, return multiplication(乘法) of the numbers as a string.

   Note: The numbers can be arbitrarily(任意) large and are non-negative.
 */
public class MultiplyStrings {
  /**
   *               123
   *             X 123
   *     ----------------------
   *               369
   *              146
   *             123
   *     ----------------------
   *             14129             
   */
  public String multiply(String num1, String num2) {
    if(num1.equals("0") || num2.equals("0"))return "0";
    
    String n1 = new StringBuilder(num1).reverse().toString();
    String n2 = new StringBuilder(num2).reverse().toString();
    StringBuilder res = new StringBuilder();
    int size = n1.length()+n2.length();
    int[] tmp = new int[size];
    for(int i=0; i<n1.length(); i++){
      for(int j=0; j<n2.length();j++){
        tmp[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
      }
    }
    
    for(int k=0; k<size; k++){
      int digit = tmp[k] % 10;
      int carry = tmp[k]/10;
      
      if(k < size - 1){
        tmp[k+1] += carry;
      }
      
      res.insert(0, digit);
    }
    if(res.charAt(0) == '0')res.deleteCharAt(0);
    return res.toString();
  }
}
