package com.iwendy.leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based. 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] numbers = {5,5,4,75,25};
    int target = 100;
    int[] ret = twoSum1(numbers, target);
    System.out.println("index1=" + ret[0]+ ", index2=" + ret[1]);
  }

  /**
   * user case
   * 1. numbers={2, 7, 11, 15}, target=9
   * 2. numbers={2, 7, 11, -11}, target=0
   * 3. numbers={2, 7, 0, 0}, target=0
   */
  public static int[] twoSum1(int[] numbers, int target) {
    int index1 = 0;
    int index2 = 0;
    HashMap<Integer, Integer> keys = new HashMap<>();

    for(int i =0; i<numbers.length; i++){
      int d = target-numbers[i];
      if(keys.containsKey(d)){
        if(i - keys.get(d) > 0){
          index1 = keys.get(d);
          index2 = i;
        }else{
          index2 = keys.get(d);
          index1 = i;
        }
        break;
      }else{
        keys.put(numbers[i],i);
      }
    }// for end
    return new int[]{index1+1,index2+1};
  }

}
