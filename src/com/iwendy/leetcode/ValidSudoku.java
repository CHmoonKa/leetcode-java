package com.iwendy.leetcode;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    
    
    A partially filled sudoku which is valid.
    
    Note:
    A valid Sudoku board (partially filled) is not necessarily solvable. 
    Only the filled cells need to be validated.
 */
public class ValidSudoku {
  
  /**
   * 可以,1.判断行,2.判断列,3.判断每一个小的九宫格.
   * 判断小的九宫格:
   * int = LITTLESQU = 3
   *  bool squValid(vector<vector<char> > &board)  
    {  
        vector<bool> nine(SQUARENUM+1, 0);  
        for (int i = 0; i < SQUARENUM; i++)  
        {  
            for (int j = 0; j < SQUARENUM; j++)  
            {  
                int row = j/LITTLESQU + i/LITTLESQU*LITTLESQU,   
                col = j%LITTLESQU + i%LITTLESQU*LITTLESQU;  
                if (board[row][col]!= '.')  
                {  
                    int t = board[row][col] - '0';  
                    if (nine[t])  
                        return false;  
                    else  
                        nine[t] = 1;  
                }  
            }  
            nine.clear();  
            nine.resize(SQUARENUM+1, 0);  
        }  
        return true;  
    }  
    
    关键是 row, 和 col:
    int row = j/LITTLESQU + i/LITTLESQU*LITTLESQU,   
    int col = j%LITTLESQU + i%LITTLESQU*LITTLESQU;  
    
    可以将3个判断一起做.
   */
  public boolean isValidSudoku(char[][] board) {
    boolean[] row = new boolean[9];
    boolean[] col = new boolean[9];
    boolean[] squ = new boolean[9];
    for (int i = 0; i < 9; i++)  
    {  
        Arrays.fill(row, false);
        Arrays.fill(col, false);
        Arrays.fill(squ, false);
        for (int j = 0; j < 9; j++)  
        {  
            if (board[i][j] != '.')   
            {  
                int r = board[i][j] - '1';  
                if (!row[r]) row[r] = true;  
                else return false;  
            }  
            if (board[j][i] != '.')  
            {  
                int c = board[j][i] - '1';  
                if (!col[c]) col[c] = true;  
                else return false;  
            }  
            int r = i/3*3+j/3; 
            int c = i%3*3+j%3;  
            if (board[r][c] != '.')  
            {  
                int sq = board[r][c] - '1';  
                if (!squ[sq]) squ[sq] = true;  
                else return false;  
            }  
        }  
    }  
    return true;
  }
}
