package com.iwendy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(numRows <= 0)return res;
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for(int i=2; i<=numRows; i++){
			int size = list.size();
			List<Integer> t = new ArrayList<>();
			t.add(1);
			for(int j=1; j<size;j++){
				t.add(list.get(j-1) + list.get(j));
			}
			t.add(1);
			res.add(list);
			list = t;
		}
		
		res.add(list);
		return res;
    }
}
