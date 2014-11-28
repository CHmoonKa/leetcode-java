package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

  For example,
  path = "/home/", => "/home"
  path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
  public static void main(String[] args) {
    System.out.println(simplifyPath("/..."));
  }
  
  public static String simplifyPath(String path) {
    int i = 0;
    List<String> stack = new ArrayList<>();
    int len = path.length();
    while(i < len)
    {
      
      // find the start position
      while(i<len && path.charAt(i) == '/'){
        i++;
      }
      if(i == len){
        break;
      }
      int start = i;
      
      // find the end position
      while(i<len && path.charAt(i) != '/') {
        i++;
      }
      int end = i; 
      
      // handle the directory
      String element = path.substring(start, end);
      if ("..".equals(element)) {
        if (stack.size() > 0) {
          stack.remove(stack.size() - 1);
        }
      } else if (!".".equals(element)) {
        stack.add(element);
      }
    }//while
    
    if (stack.size() == 0) return "/";
    
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < stack.size(); j++)
      sb.append("/").append(stack.get(j));
    
    return sb.toString();
  }
}
