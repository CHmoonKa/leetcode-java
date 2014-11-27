package com.iwendy.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".
 */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
	
	public static String addBinary(String a, String b) {
		int m = a.length();
		int n = b.length();
		int carry = 0;
		StringBuilder res = new StringBuilder();
		int maxLen = Math.max(m, n);
		for (int i = 0; i < maxLen; i++) {
			int p = 0, q = 0;
			if (i < m)
				p = a.charAt(m - 1 - i) - '0';
			else
				p = 0;

			if (i < n)
				q = b.charAt(n - 1 - i) - '0';
			else
				q = 0;

			int tmp = p + q + carry;
			carry = tmp / 2;
			res.insert(0, tmp % 2);
		}
		if (carry != 0){
			res.insert(0, carry);
		}
		return res.toString();
	}
}
