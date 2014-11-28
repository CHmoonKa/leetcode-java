package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	
	For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 ||
        	board == null || board.length == 0 ||
        	board[0].length == 0)
        {
        	return false;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        // 标记是否已经访问，因为The same letter cell may not be used more than once.
        boolean[] visited = new boolean[row*col];
        Arrays.fill(visited, false);
        
        // 首先找到与第一个字符相同的点。
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++)
        	{
        		// 找到了
        		if(board[i][j] == word.charAt(0) && !visited[i*col + j])
        		{
        			visited[i*col + j] = true;
        			if(dfs(board,word,visited,1,-1,i,j))
        			{
        				return true;
        			}
        			visited[i*col + j] = false;
        		}
        	}//forj
        }//for i
        
        return false;
    }
	
	boolean dfs(char[][] board,String word,boolean[] visited,
			int size, // already match count
			int op, //0 up, 1 down, 2 left, 3 right
			int i,// row
			int j)// col
	{
		if(size == word.length())
		{
			return true;
		}
		
		int row = board.length;
        int col = board[0].length;
        
        /**
         * op: 代表上一次的操作，可能是上下左右搜索
         * 如果上一次是向上(op=0)搜索的话，那么本次就不能向下搜索。
         */
		if(i+1 < row && op != 0)
		{
			if(board[i+1][j] == word.charAt(size) && !visited[(i+1)*col + j]){
				visited[(i+1)*col + j] = true;
				if(dfs(board,word,visited,size+1,1,i+1,j))
    			{
    				return true;
    			}
				visited[(i+1)*col + j] = false;
			}
		}//向下搜索
		
		if(i-1 >= 0 && op != 1)
		{
			if(board[i-1][j] == word.charAt(size) && !visited[(i-1)*col + j]){
				visited[(i-1)*col + j] = true;
				if(dfs(board,word,visited,size+1,0,i-1,j))
    			{
    				return true;
    			}
				visited[(i-1)*col + j] = false;
			}
		}//向上搜索
		
		if(j+1 < col && op != 2)
		{
			if(board[i][j+1] == word.charAt(size) && !visited[i*col + j + 1]){
				visited[i*col + j + 1] = true;
				if(dfs(board,word,visited,size+1,3,i,j+1))
    			{
    				return true;
    			}
				visited[i*col + j + 1] = false;
			}
		}//向右搜索
		
		if(j-1 >= 0 && op != 3)
		{
			if(board[i][j-1] == word.charAt(size) && !visited[i*col + j - 1]){
				visited[i*col + j - 1] = true;
				if(dfs(board,word,visited,size+1,2,i,j-1))
    			{
    				return true;
    			}
				visited[i*col + j - 1] = false;
			}
		}//向左搜索
		
		return false;
	}
}
