package com.iwendy.leetcode;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation(逆波兰式).

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
	/**
	 * 对于逆波兰式，一般都是用栈来处理，
	 * 1. 依次处理字符串， 如果是数值，则push到栈里面
	 * 2. 如果是操作符，则从栈中pop出来两个元素，计算出值以后，再push到栈里面.
	 * 3. 最后栈里面剩下的元素即为所求。
	 */
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0){
			return 0;
		}
		
		int len = tokens.length;
		int[] stack = new int[len];
		int top = 0;
		
		for(int i=0; i<len; i++)
		{
			if(isOperator(tokens[i]))
			{
				int o2 = stack[--top]; // 第一个操作数在stack的下边
				int o1 = stack[--top];
				switch (tokens[i]) {
				case "+":
					stack[top++] = o1 + o2;
					break;

				case "-":
					stack[top++] = o1 - o2;
					break;

				case "*":
					stack[top++] = o1 * o2;
					break;

				case "/":
					stack[top++] = o1 / o2;
					break;
				}
			}
			else{
				stack[top++] = Integer.parseInt(tokens[i]);
			}
		}
		
		return stack[0];
	}
	
	public boolean isOperator(String s){
		if("+".equals(s) ||
		   "-".equals(s) ||
		   "*".equals(s) ||
		   "/".equals(s)){
			return true;
		}
		
		return false;
	}
	
}
