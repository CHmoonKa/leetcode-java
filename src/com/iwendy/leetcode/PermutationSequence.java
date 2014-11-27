package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

  By listing and labeling all of the permutations in order,
  We get the following sequence (ie, for n = 3):
  
  "123"
  "132"
  "213"
  "231"
  "312"
  "321"
  Given n and k, return the kth permutation sequence.
  
  Note: Given n will be between 1 and 9 inclusive.
  
  首先给了我们n还有k，在数列 1，2，3，... , n构建的全排列中，返回第k个排列。
  那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。
  所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。
  1. 所以,首先需要知道k里有几个(n-1)!,利用 k/(n-1)! 可以取得最高位在数列中的index。
  2. 然后，新的k就可以有k%(n-1)!获得。循环n次即可。
 */
public class PermutationSequence {
  public String getPermutation(int n, int k) {
    k--;//to transfer it as begin from 0 rather than 1
    
    List<Integer> numList = new ArrayList<Integer>();  
    for(int i = 1; i<= n; i++)
        numList.add(i);
   
    int times = n-1;
    int factorial = 1;  //(n-1)!  
    for(int i = 2; i < n; i++)  
        factorial *= i;    
    
    StringBuilder res = new StringBuilder();
    while(times>=0){
        int indexInList = k/factorial;
        res.append(numList.get(indexInList));  
        numList.remove(indexInList);  
        
        k = k%factorial;//new k for next turn
        if(times!=0)
            factorial = factorial/times;//new (n-1)!
        
        times--;
    }
    
    return res.toString();
  }
}
