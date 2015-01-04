package com.iwendy.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
   int sum = 0;
   if(n <= 1){
     return sum;
   }
   
   while(n > 0){
     sum += n/5;
     n = n/5;
   }
   
   return sum;
  }
}
