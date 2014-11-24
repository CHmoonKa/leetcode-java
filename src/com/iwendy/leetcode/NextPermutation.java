package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding 
 * outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 所谓一个排列的下一个排列的意思就是: 这一个排列与下一个排列之间没有其他的排列。
 * 这就要求这一个排列与下一个排列有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。可能理解起来比较难懂。
 * 对于数字序列：
 * 7 8 6 9 8 7 2
 * 7 8 7 9 8 6 2 
 * 7 8 7 2 6 8 9 
 * 先看前面2排的话，可以看出来第二排是比第一排要大的，参考字符串比较大小的问题。
 * 那么第2个排列是不是第一个排列的下一个排列呢。很明显不是，第3个排列才是
 */
public class NextPermutation {
  
  /**
   *1.从后往前，找到第一个 A[i-1] < A[i]的。
   *2.从 A[n-1]到A[i]中找到一个比A[i-1]大的值（也就是说在A[n-1]到A[i]的值中找到比A[i-1]大的集合中的最小的一个值）
   *3.交换这两个值，并且把A[n-1]到A[i]排序，从小到大。
   */
  public void nextPermutation(int[] num) {
    int key = num.length - 1;
    //1. find the key
    while(key > 0){
      if(num[key -1] < num[key]){
        break;
      }
      key--;
    }
    
    //2. 没有找到,只需要倒置数组即可
    if(key == 0){
      for(int i=0,j=num.length-1;i<j;i++,j--){
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
      }
      return;
    }
    
    int index = num.length-1;
    for(; index>= key;index--){
      if(num[index] > num[key-1]){
        break;
      }
    }
    int t = num[key-1];
    num[key-1] = num[index];
    num[index] = t;
    
    // sort
    Arrays.sort(num, key, num.length);
  }
}
