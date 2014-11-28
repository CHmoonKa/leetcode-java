package com.iwendy.leetcode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0)return digits;
    
    int[] ta = new int[digits.length+1];
    int carry = 0;
    int index = digits.length - 1;
    
    int t = digits[index] + 1;
    carry = t / 10;
    digits[index] = t%10;
    ta[index+1] = digits[index];
    index--;
    while(index >= 0){
      int tmp = digits[index] + carry;
      carry = tmp / 10;
      digits[index] = tmp % 10;
      ta[index+1] = digits[index];
      index--;
    }
    if(carry == 0){
      return digits;
    }else{
      ta[0] = carry;
      return ta;
    }//if
  }//
}
