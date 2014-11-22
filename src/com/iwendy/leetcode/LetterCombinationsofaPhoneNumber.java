package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("10"));
	}

	public static List<String> letterCombinations(String digits) {  
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
        List<String> list = new ArrayList<String>();  
        calc(digits, map, list, new StringBuilder(), 0);  
        return list;  
    }  
      
    public static void calc(String digits, String[] map, List<String> list, StringBuilder sb, int pos) {  
        if(pos == digits.length()) {  
            list.add(sb.toString());  
            return;  
        }  
          
        String s = map[digits.charAt(pos)-'0'];  
        for(int i=0; i<s.length(); i++) {  
            sb.append(s.charAt(i));  
            calc(digits, map, list, sb, pos+1);  
            sb.deleteCharAt(sb.length()-1);  
        }  
    } 
}
