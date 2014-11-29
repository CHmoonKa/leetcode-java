package com.iwendy.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
  
  You are given a target value to search. If found in the array return its index, otherwise return -1.
  
  You may assume no duplicate exists in the array.
 */
public class SearchinRotatedSortedArray {
  
  /**
   * No roated:    1 2 3 4 5 6 7
   * Left roated:  3 4 5 6 7 1 2,从左边向右边移动
   * Right roated: 6 7 1 2 3 4 5,从右边向左边移动
   * 
   * 从上面可以知道,无论旋转多少次,当取一个点时,左右两边必有一边是有序的.
   */
  public int search(int[] A, int target) {
    int l = 0, r = A.length - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (A[m] == target) return m;
      
      // 左边是升序的
      if (A[m] >= A[l]) {
        if (A[l] <= target && target < A[m])
          r = m - 1;
        else
          l = m + 1;
      } 
      // 左边无序,则右边是有序的
      else {
        if (A[m] < target && target <= A[r])
          l = m + 1;
        else
          r = m - 1;
      }
    }
    return -1;
  }
}
