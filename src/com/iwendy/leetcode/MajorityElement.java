package com.iwendy.leetcode;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
  
  /**
   * 1.思路：对数组进行排序，排序过后，数组的主元素必定位于数组中间的位置。
   *   sort(num);  
   *   return num[num.size()/2];  
   * 2.每个数字都投自己一票，结果一定是大多数的数字胜出。不同数字的得票可以相互抵消。
   */
  public int majorityElement(int[] num) {
    int count = 1;
    int value = num[0];
    
    for(int i=1; i<num.length; i++)
    {
      if (count == 0) {
        count++;
        value = num[i];
      } else if (value == num[i])
        count++;
      else
        count--;
    }
    return value;
  }
}
