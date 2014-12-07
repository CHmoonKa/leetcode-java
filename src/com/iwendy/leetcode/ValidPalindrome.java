package com.iwendy.leetcode;

/**
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	/**
	 * "1a2" is false
	 */
	public boolean isPalindrome(String s) {
		if(s == null || s.length() <= 1) return true;
		
		int i = 0;
		int j = s.length() - 1;
		
		s = s.toLowerCase();
		while(i <= j)
		{
			
			if(!isAZ(s.charAt(i))){
				i++;
				continue;
			}
			if(!isAZ(s.charAt(j))){
				j--;
				continue;
			}
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}//while
		return true;
    }
	
	public boolean isAZ(char c){
		if(c >= '0' && c <= '9')return true;
		if(c >= 'a' && c <= 'z')return true;
		return false;
	}
}
