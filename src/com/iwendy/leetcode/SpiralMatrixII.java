package com.iwendy.leetcode;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

  For example,
  Given n = 3,
  
  You should return the following matrix:
  [
   [ 1, 2, 3 ],
   [ 8, 9, 4 ],
   [ 7, 6, 5 ]
  ]
  
  n = 4,
  1  2  3  4
 12 13 14  5
 11 16 15  6
 10  9  8  7
 */
public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int i = 0;
    int j = n-1;
    int num = 1;
    int[][] res = new int[n][n];
    
    for(;i<j;i++,j--){
      for(int k=i;k<=j;k++){
        res[i][k] = num++;
      }
      for(int k=i+1;k<j;k++){
        res[k][j] = num++;
      }
      for(int k=j;k>i;k--){
        res[j][k] = num++;
      }
      for(int k=j;k>i;k--){
        res[k][i] = num++;
      }
    }//
    if(i == j)res[i][j] = num;
    return res;
  }
}
