package com.iwendy.leetcode;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchforaRange {
  
  public int[] searchRange_2(int[] A, int target) {
    int[] res = {-1,-1};
    int index = searchTarget(A, 0, A.length - 1, target);
    if (index == -1) {
     return res;
    } else {
      int is = index;
      while (is > 0 && A[is - 1] == A[index])
        is--;
      int ie = index;
      while (ie < A.length - 1 && A[ie + 1] == A[index])
        ie++;
      res = new int[]{is,ie};
    }
    return res;
  }
  
  int searchTarget(int A[], int start, int end, int target) {
    if (start > end) return -1;
    int mid = (start + end) / 2;
    if (A[mid] == target) return mid;
    if (A[mid] < target)
      return searchTarget(A, mid + 1, end, target);
    else
      return searchTarget(A, start, mid - 1, target);
  }
  
  // 可以占有一个值,如[1,2,3] 2, result is [1,1]
  public int[] searchRange(int[] A, int target) {
    int h = 0;
    int t = A.length - 1;
    boolean ish = false;
    boolean ist = false;
    
    while(h <= t && (!ish || !ist)){
      if(A[t] != target){
        t--;
      }else{
        ist = true;
      }
      
      if(A[h] != target){
        h++;
      }else{
        ish = true;
      }
    }
    
    if(ish && ist){
      return new int[]{h,t};
    }
    
    return new int[]{-1,-1};
  }
}
