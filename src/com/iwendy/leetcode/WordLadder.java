package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary,
 *  find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	public static void main(String[] args) {
		String[] ss = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};

		Set<String> dict = new HashSet<String>();
		for(int i=0; i<ss.length; i++){
			dict.add(ss[i]);
		}
		
		WordLadder wl = new WordLadder();
		
		System.out.println(wl.ladderLength_bfs("qa","sq", dict));
	}
	
	// browser first search
	public int ladderLength_bfs(String start, String end, Set<String> dict){
		if(start==null || end==null || start.length()==0 || end.length()==0 
				|| start.length()!=end.length())  
	        return 0;
		
		LinkedList<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(start);
		visited.add(start);
		
		int current = 1;
		int next = 0;
		int size = 1;
		while(!queue.isEmpty()){
			String word = queue.poll();
			current--;
			if(word.equals(end))return size+1;
			
			for(int i=0; i<word.length(); i++){
				char[] charCur = word.toCharArray(); 
				for(char c='a'; c<='z'; c++){
					charCur[i] = c;
					String t = new String(charCur);
					if(t.equals(end))return size + 1;
					
					if(dict.contains(t) && !visited.contains(t))
					{
						next++;
						visited.add(t);
						queue.add(t);
					}
				}
			}//for word
			
			if(current == 0)
			{
				current = next;
				next = 0;
				size++;
			}
		}
		
		return 0;
	}
	
	// deep first search
	public int ladderLength_dfs(String start, String end, Set<String> dict){
		String[] diffs = findStrings(dict, start);
		int min = Integer.MAX_VALUE;
		if(diffOneWord(start, end)){
			return 2;
		}
		
		for(int i=0; i<diffs.length; i++){
			dict.remove(diffs[i]);
			int m = 1 + ladderLength_dfs(diffs[i], end, dict);
			min = m < min?m:min;
			dict.add(diffs[i]);
		}
		
		return min;
	}
	
	public String[] findStrings(Set<String> dict, String key){
		List<String> res = new ArrayList<>();
		for(String s : dict){
			if(diffOneWord(s, key)){
				res.add(s);
			}
		}
		
		return res.toArray(new String[res.size()]);
	}
	
	public boolean diffOneWord(String s, String key){
		int diff = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) != key.charAt(i))
				diff++;
		}
		
		return diff == 1;
	}
	
}
