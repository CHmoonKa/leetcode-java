package com.leetcode.solutions;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
    System.out.println(lengthOfLongestSubstring(s));
  }

  /**
   * the ascii table & extended ascii table together have 256 characters. 
   */
  public static int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0){
      return 0;
    }
    int max = 1;
    int point = -1;
    int chs[] = new int[256];
    for(int i=0; i<256; i++){
      chs[i] = -1;
    }
    for(int i=0; i<s.length();i++){
      if(chs[s.charAt(i)] != -1 && point < chs[s.charAt(i)]){
        point = chs[s.charAt(i)];
      }
      if(i - point > max){
        max = i - point;
      }
      
      chs[s.charAt(i)] = i;
    }
    return max;
  }

}
