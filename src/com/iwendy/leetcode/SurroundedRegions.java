package com.iwendy.leetcode;

import java.util.LinkedList;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {
	
	public void solve_dfs(char[][] board) {
		if(board == null || board.length == 0)return;
		int row = board.length;
        if(row < 2)
            return;
        int col = board[0].length;
        if(col < 2)
            return;
        
        //top
        for(int i=0;i<col;i++)
        {
            if(board[0][i] == 'O')
            {
                board[0][i] = '#';
                dfs(board, 0, i, row, col);
            }
        }
        // bottom
        for(int i=0;i<col;i++)
        {
            if(board[row-1][i] == 'O')
            {
                board[row-1][i] = '#';
                dfs(board, row-1, i, row, col);
            }
        }
        //left
        for(int i=1;i<row-1;i++)
        {
            if(board[i][0] == 'O')
            {
                board[i][0] = '#';
                dfs(board, i, 0, row, col);
            }
        }
        // right
        for(int i=1;i<row-1;i++)
        {
            if(board[i][col-1] == 'O')
            {
                board[i][col-1] = '#';
                dfs(board, i, col-1, row, col);
            }
        }
        
        //将'O'变为'X'，将'#'恢复回'O'
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
	}
	
	public void dfs(char[][] board,int i,int j, int r, int c){
		if(i>1 && board[i-1][j] == 'O'){
			board[i-1][j] = '#';
			dfs(board,i-1,j,r,c);
		}
		if(i<r-2 && board[i+1][j] == 'O'){
			board[i+1][j] = '#';
			dfs(board,i+1,j,r,c);
		}
		if(j>1 && board[i][j-1] == 'O'){
			board[i][j-1] = '#';
			dfs(board,i,j-1,r,c);
		}
		if(j<c-2 && board[i][j+1] == 'O'){
			board[i][j+1] = '#';
			dfs(board,i,j+1,r,c);
		}
	}
	
	/**
	 * 从四边开始，如果有 ‘0’在边上则它一定没有被包含，与它相连的也不会被包含。
	 * 则这样的'O'保留，其他的
	 * 这个是 bfs，但是Time Limit Exceeded
	 */
	public void solve_bfs(char[][] board) {
		if(board == null || board.length == 0)return;
		
        LinkedList<Integer> xq = new LinkedList<>();
        LinkedList<Integer> yq = new LinkedList<>();
        LinkedList<Integer> visited = new LinkedList<>();
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0; i<c; i++){
        	if(board[0][i] == 'O'){
        		xq.add(0);
        		yq.add(i);
        		visited.add(i);
        	}
        }
        for(int i=1; i<r; i++){
        	if(board[i][c-1] == 'O'){
        		xq.add(i);
        		yq.add(c-1);
        		visited.add(i*r+c-1);
        	}
        }
        for(int i=c-2; i>=0; i--){
        	if(board[r-1][i] == 'O'){
        		xq.add(r-1);
        		yq.add(i);
        		visited.add(r*(r-1)+i);
        	}
        }
        for(int i=r-2; i>0; i--){
        	if(board[i][0] == 'O'){
        		xq.add(i);
        		yq.add(0);
        		visited.add(i*r);
        	}
        }
        
        while(!xq.isEmpty()){
        	int i = xq.poll();
        	int j = yq.poll();
        	
        	board[i][j] = 'Z';
        	if(i>0 && board[i-1][j] == 'O' && !visited.contains((i-1)*r+j)){
        		xq.add(i-1);
        		yq.add(j);
        		visited.add((i-1)*r+j);
        	}//上
        	if(i<r-1 && board[i+1][j] == 'O' && !visited.contains((i+1)*r+j)){
        		xq.add(i+1);
        		yq.add(j);
        		visited.add((i+1)*r+j);
        	}//下
        	if(j>0 && board[i][j-1] == 'O' && !visited.contains(i*r+j-1)){
        		xq.add(i);
        		yq.add(j-1);
        		visited.add(i*r+j-1);
        	}//左
        	if(j<c-1 && board[i][j+1] == 'O' && !visited.contains(i*r+j+1)){
        		xq.add(i);
        		yq.add(j+1);
        		visited.add(i*r+j+1);
        	}//右
        }
        
      for(int i=0;i<r;i++){
    	  for(int j=0;j<c;j++){
    		  if(board[i][j] == 'O'){
    			  board[i][j] = 'X';
    		  }else if(board[i][j] == 'Z'){
    			  board[i][j] = 'O';
    		  }
    	  }
      }
        
    }
}
