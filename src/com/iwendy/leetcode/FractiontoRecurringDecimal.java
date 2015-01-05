package com.iwendy.leetcode;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractiontoRecurringDecimal {

  public static void main(String[] args) {
    System.out.println(fractionToDecimal(-1, -2147483648));
  }
  
  /**
   * 1. 如何识别循环体？
   * 用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。
   * 
   * 2. 在不断相除的过程中，把余数乘以10再进行下一次相除，保证一直是整数相除；
   * 8/7 = 1.(1/7) --> 10/7
   * 
   * 3. HashMap的key和value分别是<当前余数, 对应结果下标>
   * 
   * @param numerator 分子
   * @param denominator 分母
   */
  public static String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";  
    if (denominator == 0) return "";  
      
    String result = "";  
      
    /**
     * 异或(^) : 相同为假, 不同为真  
     */
    if ((numerator < 0) ^ (denominator < 0)) {  
      result += "-";  
    }  
      
    //下面要把两个数都转为正数，为避免溢出，int转为long
    long fz = numerator;
    long fm = denominator;
    fz = Math.abs(fz);  
    fm = Math.abs(fm);  
      
    //结果的整数部分  
    long res = fz / fm;  
    result += String.valueOf(res);  
      
    //如果能够整除，返回结果  
    long rem = (fz % fm) * 10;  
    if (rem == 0) return result;  
    
    //结果的小数部分
    result += "."; 
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();  
    while(rem != 0)
    {
      // 包含相同余数, 说明小数开始循环
      if(map.containsKey(rem))
      {
        int beg = map.get(rem); //循环体开始的位置  
        String part1 = result.substring(0, beg);  
        String part2 = result.substring(beg, result.length());  
        result = part1 + "(" + part2 + ")";  
        return result; 
      }
      
      map.put(rem, result.length());
      
      res = rem / fm;
      result += String.valueOf(res);
      rem = (rem % fm)*10;
    }
    
    return result;
  }
}
