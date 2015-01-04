package com.iwendy.leetcode;

/**
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and 
your function should return the index number 2.

click to show spoilers.
 */
public class FindPeakElement {
  public static void main(String[] args) {
    int[] t = new int[]{1,2,3,1};
    
    System.out.println(findPeakElement(t));
  }
  
  public static int findPeakElement(int[] num) {
    if(num == null || num.length == 0){
      return -1;
    }
    
    int len = num.length;
    
    if(len == 1){
      return 0;
    }
    
    int index = -1;
    if(num[0] > num[1]){
      index = 0;
    }
    
    int i=1;
    for(; i<len-1; i++)
    {
      if(num[i-1] < num[i] && num[i] > num[i+1]){
        index = i;
        break;
      }
    }
    
    if(i == len-1 && num[i] > num[i-1]){
      index = i;
    }
    return index;
  }
}
