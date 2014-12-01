package com.iwendy.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
  /**
   * 作为根的元素,左边的数字小于它,右边的数字大于它.
   * 以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成.
   * 所以,以i为节点的适合,是左边子树(n=i-1)*(n=n-i)
   * 
   * n = 0     1
   * {空}      
   * n = 1     1
   * 1         
   * 
   * n = 2     2
   * 1        2
   *  \      /
   *   2    1
   */
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    
    //n 范围[2,n]
    for (int i = 2; i <= n; i++) 
    {
      //j 范围[0,n-1]
      for (int j = 1; j <= i; j++) 
      {
        dp[i] += dp[j-1] * dp[i - j];
      }
    }
    return dp[n];
  }
}
