package com.iwendy.leetcode;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * [({})] is valid.
 */
public class ValidParentheses {
	public static void main(String[] args) {
		String txt = "()[]{}";
		System.out.println(isValid(txt));
	}

	public static boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0){
        	return false;
        }
        
        int size = s.length();
        char[] stack = new char[size];
        int top = 0;
        stack[top++] = s.charAt(0);
        for(int i=1; i<size; i++){
        	top = cmpChar(stack, top, s.charAt(i));
        }
        if(top == 0){
        	return true;
        }
        return false;
    }
	
	public static int cmpChar(char[] stack,int top, char c){
		stack[top++] = c;
		if(top < 2){
			return top;
		}
		char p = stack[top - 2];
		if(p == '(' && c == ')')
		{
			top = top - 2;
		}
		
		if(p == '[' && c == ']')
		{
			top = top - 2;
		}
		
		if(p == '{' && c == '}')
		{
			top = top - 2;
		}
		
		return top;
	}
}
