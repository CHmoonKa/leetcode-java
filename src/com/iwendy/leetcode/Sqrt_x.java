package com.iwendy.leetcode;

/**
 * Implement int sqrt(int x).

  Compute and return the square root of x.
 */
public class Sqrt_x {
  
  /**
   * 对于一个非负数n，它的平方根不会大于（n/2+1）
   * 二分法
   */
  public int sqrt(int x) {
    if(x<0) return -1;
    if(x==0) return 0;
    
    int i = 1;
    int j = x/2<Math.sqrt(Integer.MAX_VALUE)? x/2+1:(int)Math.sqrt(Integer.MAX_VALUE); 
    while (i <= j) {
      int mid = (i + j) / 2;
      int sq = mid * mid;
      if (sq == x) {
        return mid;
      } else if (sq < x) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }
    return j;
  }
}
