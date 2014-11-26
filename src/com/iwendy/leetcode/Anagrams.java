package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Given an array of strings, return all groups of strings that are anagrams(回文构词法).

	Note: All inputs will be in lower-case.
	
	Anagrams是指由颠倒字母顺序组成的单词，比如“dormitory”颠倒字母顺序会变成“dirty room”，“tea”会变成“eat”。

	回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
	
	For example:

	Input:　　["tea","and","ate","eat","den"]
	
	Output:   ["tea","ate","eat"]
 */
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		
		// 用排序过的string作为key，它的anagram作为ArrayList
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		for(int i=0; i<strs.length; i++){
			//String sorted = sorted(strs[i]);
			String sorted = getSequence(strs[i]);
			ArrayList<String> val = hm.get(sorted);
			if(val != null){
				val.add(strs[i]);
			}else{
				val = new ArrayList<String>();
				val.add(strs[i]);
				hm.put(sorted, val);
			}
		}
		
		// HashMap的循环方法 keySet 
		Set<String> set = hm.keySet();
		
		// 把所有anagram添加到ret中
		for(String s : set){
			ArrayList<String> val = hm.get(s);
			if(val.size() > 1){
				ret.addAll(val);
			}
		}
		
		return ret;
    }
	
	// 对每个单词做出标记，例如对于anagram标记为a3g1m1n1r1，表示这个单词有3个a，1个g等等
	public String getSequence(String s){
		if("".equals(s)){
			return "";
		}
		int[] hash = new int[256];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			hash[s.charAt(i)]++;
		}
		for(int i = 97; i < 123; i++){
			if(hash[i] != 0){
				sb.append((char)i).append(hash[i]);
			}
		}
		return sb.toString();
	}
	
	public String sorted(String a){
		char[] achar = a.toCharArray();
		Arrays.sort(achar);
		return new String(achar);
	}
}
