package com.iwendy.leetcode;

/**
 * You are given an n x n 2D matrix representing an image.
  
  Rotate the image by 90 degrees (clockwise).
  
  Follow up:
  Could you do this in-place?
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int halfN;
    if (n % 2 == 0)
        halfN = n / 2;
    else
        halfN = n / 2 + 1;
    for (int i = 0; i < halfN; i++) {
        for (int j = i; j < n - i - 1; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[n - j - 1][i];
            matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
            matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
            matrix[j][n - i - 1] = tmp;
        }
    }
  }
}
