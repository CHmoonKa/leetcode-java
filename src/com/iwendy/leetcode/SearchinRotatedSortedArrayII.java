package com.iwendy.leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array":
  What if duplicates are allowed?
  
  Would this affect the run-time complexity? How and why?
  
  Write a function to determine if a given target is in the array.
 */
public class SearchinRotatedSortedArrayII {
  
  /**
   * No roated:    1 2 3 3 3 3 3
   * Left roated:  3 3 3 3 3 1 2,从左边向右边移动
   * Right roated: 3 3 1 2 3 3 3,从右边向左边移动
   * 此时,如果是找target=1,
   * 
   * 如果A[m]>=A[l]不能确定递增，那就把它拆分成两个条件
   * 1. A[m]>A[l]  递增
   * 2. A[m] ==A[l] 确定不了，那就l++，往下看一步即可。
   */
  public boolean search(int[] A, int target) {
    int l = 0;
    int r = A.length - 1;
    while(l <= r){
      int m = (l+r)/2;  
      if(A[m]==target)  
          return true;  
      if(A[m]>A[l]) //左边有序 
      {  
          if(A[m]>target && A[l]<=target)  
          {  
              r = m-1;  
          }  
          else  
          {  
              l = m+1;  
          }  
      }  
      else if(A[m]<A[l]) //左边无序,说明右边是有序的 
      {  
          if(A[m]<target && A[r]>=target)  
          {  
              l = m+1;  
          }  
          else  
          {  
              r = m-1;  
          }                  
      }  
      else  
      {  
          l++;  
      }  
    }//while
    return false;
  }
}
