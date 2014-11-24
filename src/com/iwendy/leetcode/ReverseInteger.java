package com.iwendy.leetcode;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {

  public static void main(String[] args) {
    int x = 1534236469;
    System.out.println(reverse(x));
  }
  
  // 0. 处理 负数
  // 1. 处理 100 --> 1
  // 2. 处理 1534236469 int 越界
  public static int reverse(int x) {
    boolean low = false;
    if(x < 0){
      x = -x;
      low = true;
    }
    
    long y=0;
    long n;
    while( x>0 ){
        n = x%10;
        y = y*10 + n;
        x /= 10;
    }
    // handle overflow
    if(y > Integer.MAX_VALUE)
      return 0;
    return (int) (low ? -y : y);
  }
}
