package com.iwendy.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
  
  // 动态规划法
  public int climbStairs(int n) {
    int fn_2 = 1, fn_1 = 2;
    
    if (n == 1) return fn_2;
    if (n == 2) return fn_1;
    int fn = 0;
    
    for (int i = 3; i <= n; i++) {
      fn = fn_2 + fn_1;
      fn_2 = fn_1;
      fn_1 = fn;
    }
    return fn;
  }
  
  // 递归
  int climbStairsRecur(int n) {  //Time Limit Exceeded
    if (n == 1) return 1;  
    if (n == 2) return 2;  
    return climbStairsRecur(n-1) + climbStairsRecur(n-2);  
  }
}
