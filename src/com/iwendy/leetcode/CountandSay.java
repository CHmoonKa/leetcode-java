package com.iwendy.leetcode;

/**
 *  The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...
    
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.
    
    Note: The sequence of integers will be represented as a string.
    
    输入n，那么我就打出第n行的字符串。
    怎么确定第n行字符串呢？
    n = 1时，打印一个1。
    n = 2时，看n=1那一行，念：1个1，所以打印：11。
    n = 3时，看n=2那一行，念：2个1，所以打印：21。
    n = 4时，看n=3那一行，念：一个2一个1，所以打印：1211。
    
    以此类推。(注意这里n是从1开始的）
 */
public class CountandSay {
  public static void main(String[] args) {
    System.out.println(countAndSay(10));
  }
  
  public static String countAndSay(int n) {
    String seq = "1";// the first line;
    
    int it = 1;
    while (it < n) {
      StringBuilder ns = new StringBuilder();
      char last = seq.charAt(0);
      int count = 0;
      for (int i = 0; i < seq.length(); i++) {
        if (seq.charAt(i) == last) {
          count++;
          continue;
        } else {
          ns.append(count).append(last);
          last = seq.charAt(i);
          count = 1;
        }
      }
      // 加上最后一次的
      seq = ns.append(count).append(last).toString();
      
      it++;
    }
    return seq;
  }
}
