package com.leetcode.solutions;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

  public static void main(String[] args) {
    String txt = "AB";
    System.out.println(convert1(txt, 1));
  }
  
  /**
   * nRow = 2:
   * 0 2 4 6 8 10 12
   * 1 3 5 7 9 11 13
   *
   * nRow = 3: 
   * 0     4      8     12 
   * 1  3  5   7  9  11
   * 2     6     10
   *
   * nRow = 4:
   * 0      6       12
   * 1   5  7    11 13
   * 2 4    8  10
   * 3      9
   * 
   * 1. for the first and last row, the difference between every two is (2 * nRow – 2)
   * 2. for the middle say i-th rows, the difference between every two is 
   *    either (2 * nRow – 2 – 2 * i) or (2 * i) in turn
   */
  public static String convert2(String s, int nRows) {
    return null;
  }
  
  
  public static String convert1(String s, int nRows) {
    if(nRows == 1){
      return s;
    }
    StringBuilder[] tmp = new StringBuilder[nRows];
    for(int i = 0; i< nRows; i++){
      tmp[i] = new StringBuilder();
    }
    int index = 0;
    boolean down = true;
    for(char a : s.toCharArray()){
      if(down){
        tmp[index++].append(a);
      }else{
        tmp[--index].append(a);
      }
      
      if(index == nRows){
        down = false;
        index--;
      }
      if(index == 0){
        down = true;
        index++;
      }
      
    }
    String ret = "";
    for(int i = 0; i< nRows; i++){
      ret += tmp[i].toString();
    }
    return ret;
  }
}
